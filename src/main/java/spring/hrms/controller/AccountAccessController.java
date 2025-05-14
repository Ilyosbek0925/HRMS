package spring.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.AccountAccessRequest;

@RequestMapping("AccountAccess")
@RestController
public class AccountAccessController {
@PostMapping("addAccount{storageId}")
    public ResponseEntity addAccount(@RequestBody AccountAccessRequest request, @PathVariable int storageId) {


    



}


}
