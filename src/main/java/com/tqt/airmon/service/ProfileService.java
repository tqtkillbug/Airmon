package com.tqt.airmon.service;

import com.tqt.airmon.model.Profile;
import com.tqt.airmon.model.Source;
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

    public Profile getById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Profile updateProfile(Long id, Profile profileUpdate) {
        Profile existingProfile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Source not found"));
        existingProfile.setName(profileUpdate.getName());
        existingProfile.setBackup(profileUpdate.getBackup());
        existingProfile.setLocation(profileUpdate.getLocation());
        existingProfile.setDescription(profileUpdate.getDescription());
        return repository.save(existingProfile);
    }
}
