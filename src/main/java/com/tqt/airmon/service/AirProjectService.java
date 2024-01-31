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

    public AirProject getProjectById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public AirProject updateProject(Long id, AirProject project) {
        AirProject existingProject = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Source not found"));
        existingProject.setName(project.getName());
        existingProject.setDescription(project.getDescription());
        existingProject.setNote(project.getNote());
        existingProject.setSource(project.getSource());
        existingProject.setStatus(project.getStatus());
        existingProject.setLinkSource(project.getLinkSource());
        return repository.save(existingProject);
    }
}
