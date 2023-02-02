package com.liwanag.demo.controller;

import com.liwanag.demo.model.Account;
import com.liwanag.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(path="/accounts")
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accounts = accountService.getAllAccounts();
        return accounts;
    }

    @GetMapping(path="/account/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        Optional<Account> account = accountService.getAccountById(id);
        return account.get();
    }

    @PostMapping(path="/account")
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @GetMapping(path="/accounts-order-by-lastname")
    public ArrayList<Account> getAllAccountsOrderByLastname() {
        ArrayList<Account> accounts = accountService.getAllAccountsOrderByLastname();
        return accounts;
    }
}
