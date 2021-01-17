package com.example.demo_spring_jpa.repository;

import com.example.demo_spring_jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
