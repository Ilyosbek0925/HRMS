package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.ManagerSettingRequest;
import spring.hrms.DTO.response.ManagerSettingResponse;
import spring.hrms.entity.manager.ManagerSetting;
import spring.hrms.mapper.ManagerSettingMapper;
import spring.hrms.repository.SettingRepository;

@Service
@RequiredArgsConstructor
public class SettingService {
    private final SettingRepository repository;
    private final ManagerSettingMapper mapper;

    public ManagerSettingResponse getSettingsByManagerId(Integer managerId) {
        return mapper.toManagerSettingResponse(repository.findById(managerId).orElseThrow(() -> new RuntimeException("not found")));
    }

    public ManagerSettingResponse updateSettings(Integer managerId, ManagerSettingRequest request) {
        ManagerSetting setting = mapper.toManagerSetting(managerId, request);
        return mapper.toManagerSettingResponse(repository.save(setting));
    }
}
