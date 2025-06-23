package spring.hrms.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.request.LoginRequest;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.ManagerService;
import spring.hrms.service.auth.AuthService;
import spring.hrms.service.jwt.JwtService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ManagerService managerService;
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(token);
    }

@PutMapping("/forget-password")
    public ResponseEntity<ApiResponseDto> forgetPassword(@RequestParam String email){
        managerService.updatePassword(email);
return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS,"code is sent to email successfully", LocalDateTime.now()));
}
@PutMapping("/check-password")
    public ResponseEntity<ApiResponseDto> checkPassword(@RequestBody LoginRequest loginRequest){
        managerService.checkPassword(loginRequest);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS,"password update successfully", LocalDateTime.now()));


}




}