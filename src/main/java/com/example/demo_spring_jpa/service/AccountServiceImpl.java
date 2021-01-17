package com.example.demo_spring_jpa.service;

import com.example.demo_spring_jpa.exception.DatabaseErrorException;
import com.example.demo_spring_jpa.exception.RecordNotFoundException;
import com.example.demo_spring_jpa.model.Account;
import com.example.demo_spring_jpa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(long id){
        if (accountRepository.existsById(id)){
            return accountRepository.findById(id).orElse(null);
    }
    else {
        throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteAccount(long id) {
        if(accountRepository.existsById(id)){
            accountRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }

    }

    @Override
    public long saveAccount(Account account) {
        Account newAccount = accountRepository.save(account);
        return newAccount.getAccountId();
    }

    @Override
    public void updateAccount(long id, Account account) {
        if (accountRepository.existsById(id)){
            try {
                Account existingAccount = accountRepository.findById(id).orElse(null);
                assert existingAccount != null;
                existingAccount.setFirstName(account.getFirstName());
                existingAccount.setLastName(account.getLastName());
                accountRepository.save(existingAccount);
            }
            catch (Exception exception){
                throw new DatabaseErrorException();
            }

        }
        else {
            throw new RecordNotFoundException();
        }

    }
}
