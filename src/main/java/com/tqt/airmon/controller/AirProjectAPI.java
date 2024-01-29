package com.tqt.airmon.controller;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.service.AirProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/air-project/")
public class AirProjectAPI {


    @Autowired
    private AirProjectService airProjectService;


    @PostMapping("")
    public ResponseEntity<?> insertAirProject(@RequestBody AirProject project){
        return new ResponseEntity<>(airProjectService.insert(project),HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<?> getListProject(){
        return new ResponseEntity<>(airProjectService.getAll(), HttpStatus.OK);
    }

}
