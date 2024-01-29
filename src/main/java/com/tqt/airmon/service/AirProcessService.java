package com.tqt.airmon.service;

import com.tqt.airmon.model.AirProcess;
import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.repository.AirProcessRepository;
import com.tqt.airmon.repository.AirProjectRepository;
import com.tqt.airmon.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirProcessService {

    @Autowired
    private AirProcessRepository repository;

    @Autowired
    private AirProjectService projectService;

    public AirProcess insert(AirProcess process){
      Optional<AirProject> airProjectOptional  = projectService.getById(process.getAirProject().getId());
        airProjectOptional .ifPresent(airProject -> {
            airProject.getProcess().add(process);
            projectService.insert(airProject);
        });
      return process;
    }

    public List<AirProcess> getAll(){
        return repository.findAll();
    }


}
