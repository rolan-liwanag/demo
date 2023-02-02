package com.liwanag.demo.controller;

import com.liwanag.demo.model.Account;
import com.liwanag.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(path="/accounts")
    public ResponseEntity getAllAccounts() {
        ArrayList<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(path="/account/{id}")
    public ResponseEntity getAccountById(@PathVariable Integer id) {
        Optional<Account> account = accountService.getAccountById(id);
        if(account.isPresent()) {
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/account")
    public ResponseEntity createAccount(@RequestBody Account account) {
        try {
            accountService.createAccount(account);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path="/accounts-order-by-lastname")
    public ResponseEntity getAllAccountsOrderByLastname() {
        ArrayList<Account> accounts = accountService.getAllAccountsOrderByLastname();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
