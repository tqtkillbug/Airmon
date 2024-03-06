package com.tqt.airmon.schedule;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.service.AirProjectService;
import com.tqt.airmon.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RemindProject {

    @Autowired
    private AirProjectService projectService;

    @Autowired
    private ApiService apiService;

//    @Scheduled(cron = "0 0 21 * * ?")
//    @Scheduled(fixedRate = 60000)
    public void remindProject() {
        List<AirProject> airProjects = projectService.getAll();
        List<AirProject> projectDoing = airProjects.stream().filter(p -> p.getStatus().equals(AirProjectService.STATUS_DOING)).collect(Collectors.toList());
        List<AirProject> projectNew = airProjects.stream().filter(p -> p.getStatus().equals(AirProjectService.STATUS_NEW)).collect(Collectors.toList());
        String res = apiService.callPostApi("http://demo6723008.mockable.io/notify","HAHHAHAHH");
    }
}
