package com.tqt.airmon.service;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.repository.AirProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirProjectService {

    @Autowired
    private AirProjectRepository  repository;

    public AirProject insert(AirProject project){
        return repository.save(project);
    }

    public List<AirProject> getAll(){
        return repository.findAll();
    }

    public Optional<AirProject> getById(Long id){
        return repository.findById(id);
    }
}
