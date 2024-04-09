package com.tqt.airmon.service;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.model.Remind;
import com.tqt.airmon.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemindService {

    @Autowired
    private RemindRepository remindRepository;

    @Autowired
    private AirProjectService projectService;


    public Remind insert(Remind remind){
        AirProject project = projectService.getProjectById(remind.getAirProject().getId());
        remind.setAirProject(project);
        return remindRepository.save(remind);
    }

    public Remind getByProjectId(Long id){
        return remindRepository.findByAirProjectId(id);
    }

}
