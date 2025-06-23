package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.ManagerSettingRequest;
import spring.hrms.DTO.response.ManagerSettingResponse;
import spring.hrms.service.SettingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("setting")
public class ManagerSettingController {
    private final SettingService service;

    @GetMapping
    public ResponseEntity<ManagerSettingResponse> getSettings(@RequestParam Integer managerId) {
        return ResponseEntity.ok(service.getSettingsByManagerId(managerId));
    }

    @PutMapping
    public ResponseEntity<ManagerSettingResponse> updateSettings(
            @RequestParam Integer managerId,
            @RequestBody ManagerSettingRequest request
    ) {
        return ResponseEntity.ok(service.updateSettings(managerId, request));
    }
}


