package com.tqt.airmon.service;

import com.tqt.airmon.model.Address;
import com.tqt.airmon.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address insert(Address address){
        return repository.save(address);
    }

    public List<Address> getAll(){
        return repository.findAll();
    }

    public List<Address> getListAddressByProfileId(Long id){
        return repository.findAllByProfileId(id);
    }
}
