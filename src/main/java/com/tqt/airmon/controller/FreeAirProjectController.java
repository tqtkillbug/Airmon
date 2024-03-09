package com.tqt.airmon.controller;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.service.AirProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/free/api")
@Slf4j
public class FreeAirProjectController {

    @Autowired
    private AirProjectService airProjectService;

    @PostMapping("air-project/push")
    public void insertProjectFromEtaService(@RequestBody AirProject airProject){
       log.info(String.valueOf(airProject));
       this.airProjectService.handleAirprojectFromEta(airProject);
    }




}
