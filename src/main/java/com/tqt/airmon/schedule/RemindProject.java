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

    private static final String DOMAIN_ADMIN = "http://129.152.0.253:8077/air-project/";

//    @Scheduled(cron = "0 0 21 * * ?")
    @Scheduled(cron = "0 0 10 * * ?")
    public void run21h(){
        remindProject();
    }

    @Scheduled(cron = "0 0 21 * * ?")
    public void run10h(){
        remindProject();
    }



    public void remindProject() {
        List<AirProject> airProjects = projectService.getAll();
        List<AirProject> projectDoing = airProjects.stream().filter(p -> p.getStatus().equals(AirProjectService.STATUS_DOING)).collect(Collectors.toList());
        List<AirProject> projectNew = airProjects.stream().filter(p -> p.getStatus().equals(AirProjectService.STATUS_NEW)).collect(Collectors.toList());
        StringBuilder build = new StringBuilder();
        build.append("<b>|--------------------Project DOING--------------------|</b>\n");
        for (AirProject airProject : projectDoing) {
            build.append("<strong>Name : ").append(airProject.getName()).append("</strong>\n");
            build.append("<strong>Link : ").append(airProject.getLinkSource()).append("</strong>\n");
            build.append("<strong>Admin : ").append(DOMAIN_ADMIN).append(airProject.getId()).append("</strong>\n");
            build.append("<strong>Note : ").append(airProject.getNote()).append("</strong>\n");
            build.append("<strong>Source : ").append(airProject.getSource().getName()).append("</strong>\n");
//            build.append("<strong>Quantity : ").append(airProject.getProcess().size()).append("</strong>\n");
            build.append("\n---------------------------------------------------------------\n");
        }
        String res = apiService.callPostApi("https://service.etasoft.tech/api/v1/free/notify/push",build.toString());
        build = new StringBuilder();
        build.append("<b>|--------------------Project NEW--------------------|</b>\n");
        for (AirProject airProject : projectNew) {
            build.append("<strong>Name : ").append(airProject.getName()).append("</strong>\n");
            build.append("<strong>Link : ").append(airProject.getLinkSource()).append("</strong>\n");
            build.append("<strong>Admin : ").append(DOMAIN_ADMIN).append(airProject.getId()).append("</strong>\n");
            build.append("<strong>Note : ").append(airProject.getNote()).append("</strong>\n");
            build.append("<strong>Source : ").append(airProject.getSource().getName()).append("</strong>\n");
//            build.append("<strong>Quantity : ").append(airProject.getProcess().size()).append("</strong>\n");
            build.append("\n---------------------------------------------------------------\n");
        }
        String res2 = apiService.callPostApi("https://service.etasoft.tech/api/v1/free/notify/push",build.toString());
    }
}
