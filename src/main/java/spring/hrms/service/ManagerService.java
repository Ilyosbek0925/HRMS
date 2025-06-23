package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.LoginRequest;
import spring.hrms.entity.manager.Manager;
import spring.hrms.exception.UserNotFoundException;
import spring.hrms.exception.WrongPasswordException;
import spring.hrms.repository.managerRepo.ManagerRepository;
import spring.hrms.service.emailService.EmailService;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final HashMap<String, String> savedCode = TemporaryStorage.savedCode;
    private final PasswordEncoder passwordEncoder;

    public void updatePassword(String email) {
        if (managerRepository.existsByEmail(email)) {
            String code = EmailService.sendCode(email);
            savedCode.put(email, code);
        } else {
            throw new UserNotFoundException("such email is not exist in system");
        }
    }

    public void checkPassword(LoginRequest loginRequest) {

        if (savedCode.containsKey(loginRequest.getEmail())) {
            if (!savedCode.get(loginRequest.getEmail()).equals(loginRequest.getPassword())) {
                throw new WrongPasswordException("wrong password");
            }
            Optional<Manager> byEmail = managerRepository.findByEmail(loginRequest.getEmail());
            if (byEmail.isPresent()) {
                Manager manager = byEmail.get();
                manager.setPassword(passwordEncoder.encode(savedCode.get(loginRequest.getEmail())));
                managerRepository.save(manager);
            }
        }
      else {
            throw new UserNotFoundException("such email is not exist in system");
        }
    }
}
