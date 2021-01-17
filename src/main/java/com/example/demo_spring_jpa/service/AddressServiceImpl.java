package com.example.demo_spring_jpa.service;

import com.example.demo_spring_jpa.exception.DatabaseErrorException;
import com.example.demo_spring_jpa.exception.RecordNotFoundException;
import com.example.demo_spring_jpa.model.Address;
import com.example.demo_spring_jpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressByAddressId(long addressid) {
        if(addressRepository.existsById(addressid)){
            return addressRepository.findById(addressid).orElse(null);
        }
        else{
            throw new RecordNotFoundException();
        }

    }

    @Override
    public void deleteAddress(long addressid) {
        if(addressRepository.existsById(addressid)){
            addressRepository.deleteById(addressid);
        }
        else {
            throw new RecordNotFoundException();
        }

    }

    @Override
    public long saveAddress(Address address) {
        Address newAddress = addressRepository.save(address);
        return newAddress.getAddressid();
    }

    @Override
    public void updateAddress(long addressid, Address address) {
        if(addressRepository.existsById(addressid)){
            try {
                Address existingAddress = addressRepository.findById(addressid).orElse(null);
                assert existingAddress !=null;
                existingAddress.setStreet(address.getStreet());
                existingAddress.setHouseNumber(address.getHouseNumber());
                existingAddress.setCity(address.getCity());
                addressRepository.save(existingAddress);
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
