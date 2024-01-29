package com.tqt.airmon.controller;

import com.tqt.airmon.model.Source;
import com.tqt.airmon.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/source/")
public class SourceAPI {


    @Autowired
    private SourceService sourceService;
    @PostMapping()
    public ResponseEntity<?> insertNewSource(@RequestBody Source sourceNew){
        return new ResponseEntity<>(sourceService.insert(sourceNew), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListSource(){
        return new ResponseEntity<>(sourceService.getAll(), HttpStatus.CREATED);
    }

}
