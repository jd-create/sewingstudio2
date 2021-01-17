package com.example.demo_spring_jpa.repository;

import com.example.demo_spring_jpa.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
