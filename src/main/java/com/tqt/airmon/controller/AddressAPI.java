package com.tqt.airmon.controller;

import com.tqt.airmon.model.Address;
import com.tqt.airmon.model.Profile;
import com.tqt.airmon.model.dto.ImportWalletsDTO;
import com.tqt.airmon.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class AddressAPI {


    @Autowired
    private AddressService service;


    @PostMapping("")
    public ResponseEntity<?> insertNewAddress(@RequestBody Address address){
        return new ResponseEntity<>(service.insert(address),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListAddressByProfile(@RequestParam(value = "profileId", required=false) Long profileId ){
        List<Address> list = new ArrayList<>();
        if (profileId == null){
            list = service.getAll();
        } else {
            list = service.getListAddressByProfileId(profileId);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSourceById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfileById(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateProfile(@PathVariable Long id, @RequestBody Address profile) {
        Address updateWallet = service.updateWallet(id, profile);
        return ResponseEntity.ok(updateWallet);
    }

    @GetMapping("/export")
    public ResponseEntity<?> exportPublicKeys(@RequestParam Long idProfile, @RequestParam String type,@RequestParam String chain) {
        return ResponseEntity.ok(service.exportListPublickey(idProfile, type,chain));
    }

    @PostMapping("/import")
    public ResponseEntity<?> importWallets(@RequestBody ImportWalletsDTO importWalletsDTO){
        return new ResponseEntity<>(service.importListWallet(importWalletsDTO), HttpStatus.CREATED);
    }
}
