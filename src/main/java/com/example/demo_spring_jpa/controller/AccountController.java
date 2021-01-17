package com.example.demo_spring_jpa.controller;

import com.example.demo_spring_jpa.model.Account;
import com.example.demo_spring_jpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts")
    public ResponseEntity<Object> getAccounts()
    {
        List<Account> accountList = accountService.getAllAccounts();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<Object> getAccount(@PathVariable("id") long id){
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping(value = "/accounts/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable("id") long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping(value = "/accounts")
    public ResponseEntity<Object> saveAccount(@RequestBody Account account){
        long newId = accountService.saveAccount(account);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/accounts/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable("id")long id, @RequestBody Account account){
        accountService.updateAccount(id, account);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
