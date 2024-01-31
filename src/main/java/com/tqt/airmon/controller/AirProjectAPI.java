package com.tqt.airmon.controller;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.service.AirProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/air-project")
public class AirProjectAPI {


    @Autowired
    private AirProjectService airProjectService;


    @PostMapping("")
    public ResponseEntity<?> insertAirProject(@RequestBody AirProject project){
        return new ResponseEntity<>(airProjectService.insert(project),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListProject(){
        return new ResponseEntity<>(airProjectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSourceById(@PathVariable Long id){
        return new ResponseEntity<>(airProjectService.getProjectById(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfileById(@PathVariable Long id){
        airProjectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody AirProject project) {
        AirProject updateWallet = airProjectService.updateProject(id, project);
        return ResponseEntity.ok(updateWallet);
    }

}
