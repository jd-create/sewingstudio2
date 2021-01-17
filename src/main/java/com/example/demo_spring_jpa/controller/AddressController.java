package com.example.demo_spring_jpa.controller;

import com.example.demo_spring_jpa.model.Address;
import com.example.demo_spring_jpa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/addresses")
    public ResponseEntity<Object> getAddresses(){
        List<Address> addressList = addressService.getAllAddresses();
        return new ResponseEntity<>(addressList, HttpStatus.OK);

    }

    @GetMapping(value = "/addresses/{addressid}")
    public ResponseEntity<Object> getAddress(@PathVariable("addressid") long addressid){
        Address address = addressService.getAddressByAddressId(addressid);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping(value = "/addresses/{addressid}")
    public ResponseEntity<Object> deleteAddress(@PathVariable("addressid") long addressid){
        addressService.deleteAddress(addressid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping(value = "/addresses")
    public ResponseEntity<Object> saveAddress(@RequestBody Address address){
        long newId = addressService.saveAddress(address);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }
    @PutMapping(value = "/addresses/{addressid}")
    public ResponseEntity<Object> updateAddress(@PathVariable("addressid") long addressid, @RequestBody Address address){
        addressService.updateAddress(addressid, address);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
