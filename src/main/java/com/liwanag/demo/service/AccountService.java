package com.liwanag.demo.service;

import com.liwanag.demo.model.Account;
import com.liwanag.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public ArrayList<Account> getAllAccounts() {
        return (ArrayList<Account>) accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        return account;
    }

    public ArrayList<Account> getAllAccountsOrderByLastname() {
        return (ArrayList<Account>) accountRepository.findAllOrderByLastname();
    }

    public void createAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }

}
