package com.tqt.airmon.controller;

import com.tqt.airmon.model.Address;
import com.tqt.airmon.model.Profile;
import com.tqt.airmon.service.AddressService;
import com.tqt.airmon.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address/")
public class AddressAPI {


    @Autowired
    private AddressService service;


    @PostMapping("")
    public ResponseEntity<?> insertNewAddress(@RequestBody Address address){
        return new ResponseEntity<>(service.insert(address),HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<?> getListAddressByProfile(@RequestParam Long profileId){
        List<Address> list = new ArrayList<>();
        if (profileId == null){
            list = service.getAll();
        } else {
            list = service.getListAddressByProfileId(profileId);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
