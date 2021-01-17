package com.example.demo_spring_jpa.service;


import com.example.demo_spring_jpa.model.Account;
import com.example.demo_spring_jpa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {

   List<Account> getAllAccounts();
   Account getAccountById(long id);
   void deleteAccount(long id);
   long saveAccount(Account account);
   void updateAccount(long id, Account account);


}
