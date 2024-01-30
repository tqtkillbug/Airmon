package com.tqt.airmon.controller;

import com.tqt.airmon.model.Profile;
import com.tqt.airmon.model.Source;
import com.tqt.airmon.service.ProfileService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileAPI {


    @Autowired
    private ProfileService service;


    @PostMapping("")
    public ResponseEntity<?> insertNewProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(service.insert(profile),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListProfile(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
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
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        Profile profileUpdate = service.updateProfile(id, profile);
        return ResponseEntity.ok(profileUpdate);
    }

}
