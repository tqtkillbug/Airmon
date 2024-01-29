package com.tqt.airmon.service;

import com.tqt.airmon.model.Profile;
import com.tqt.airmon.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public Profile insert(Profile profile){
        return repository.save(profile);
    }

    public List<Profile> getAll(){
        return repository.findAll();
    }
}
