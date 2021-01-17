package com.example.demo_spring_jpa.service;

import com.example.demo_spring_jpa.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();
    Address getAddressByAddressId(long addressid);
    void deleteAddress(long addressid);
    long saveAddress(Address address);
    void updateAddress(long addressid, Address address);
}
