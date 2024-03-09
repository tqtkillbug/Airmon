package com.tqt.airmon.service;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.model.Source;
import com.tqt.airmon.model.dto.DashboardData;
import com.tqt.airmon.repository.AirProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AirProjectService {


    public static final String STATUS_DOING = "DOING";
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_CLOSE = "CLOSE";
    public static final String STATUS_EXPIRED = "EXPIRED";
    public static final String STATUS_PENDING = "PENDING";

    @Autowired
    private AirProjectRepository  repository;

    @Autowired
    private SourceService sourceService;

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

    public DashboardData setDataDashboard(DashboardData data){
        List<AirProject> listAirProject = getAll();
        data.setTotalProject(listAirProject.size());
        int totalDoing = (int) listAirProject.stream().filter(t -> t.getStatus().equals(STATUS_DOING)).count();
        int totalClose = (int) listAirProject.stream().filter(t -> t.getStatus().equals(STATUS_CLOSE)).count();
        int totalNew = (int) listAirProject.stream().filter(t -> t.getStatus().equals(STATUS_NEW)).count();
        int totalExpired = (int) listAirProject.stream().filter(t -> t.getStatus().equals(STATUS_EXPIRED)).count();
        data.setTotalProjectNew(totalNew);
        data.setTotalProjectExpired(totalExpired);
        data.setTotalProjectPending(totalClose);
        data.setTotalProjectDoing(totalDoing);
        data.setTotalProjectClose(totalClose);
        return  data;
    }

    private boolean existBySourceLink(String sourceLink){
        return repository.existsByLinkSource(sourceLink);
    }

    public void handleAirprojectFromEta(AirProject airProject) {
        if (Objects.isNull(airProject)) return;

        if (existBySourceLink(airProject.getSourceLink())) return;

        String sourceChanelLink = airProject.getSourceChanelLink();
        Source exsitSource = sourceService.getSourceByLink(sourceChanelLink);
        if (Objects.isNull(exsitSource)){
            exsitSource = sourceService.insertSourceNew(airProject.getSourceName(),sourceChanelLink);
        }
        airProject.setSource(exsitSource);
        airProject.setStatus(STATUS_NEW);
        airProject.setName(getTitle(airProject.getDescription()));
        airProject.setLinkSource(airProject.getSourceLink());
        insert(airProject);
    }

    public static String getTitle(String inputString) {
        String[] wordsArray = inputString.split("\\s+");
        int wordsToExtract = Math.min(5, wordsArray.length);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordsToExtract; i++) {
            result.append(wordsArray[i]).append(" ");
        }
        return result.toString().trim();
    }


}
