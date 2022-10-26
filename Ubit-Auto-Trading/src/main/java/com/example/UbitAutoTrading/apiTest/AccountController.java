package com.example.UbitAutoTrading.apiTest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountClient accountClient;

   @GetMapping("/api/v1/accounts")
    public ResponseEntity<List<AccountResponse>> showAllAccounts() {
       return ResponseEntity.ok(accountClient.getAccounts());
    }

}