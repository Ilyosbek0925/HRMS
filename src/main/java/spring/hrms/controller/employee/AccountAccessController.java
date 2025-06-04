package spring.hrms.controller.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.AccountAccessDTO;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.employeeService.AccountAccessService;

import java.time.LocalDateTime;

@RequestMapping("account-access")
@RestController
@RequiredArgsConstructor


public class AccountAccessController {
    private final AccountAccessService service;

    @PostMapping("/{storageId}")
    public ResponseEntity<ApiResponseDto> addAccount(@RequestBody AccountAccessDTO request, @PathVariable int storageId) {
        service.add(request,storageId);
        return ResponseEntity.ok().body(new ApiResponseDto(ResponseStatus.SUCCESS,"All Employee Data added successfully",LocalDateTime.now()));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<AccountAccessDTO> getAccountAccess(@PathVariable Integer employeeId) {
        AccountAccessDTO response=service.getAccountAccess(employeeId);
        return  ResponseEntity.ok(response);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<ApiResponseDto> updateAccountAccess(@PathVariable Integer employeeId, @RequestBody AccountAccessDTO request) {
           service.update(employeeId,request);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS,"updated successfully", LocalDateTime.now()));
    }




}
