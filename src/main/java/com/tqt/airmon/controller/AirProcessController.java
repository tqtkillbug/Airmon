package com.tqt.airmon.controller;

import com.tqt.airmon.model.AirProcess;
import com.tqt.airmon.service.AirProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/process")
public class AirProcessController {

    @Autowired
    private AirProcessService service;


    @PostMapping("")
    public ResponseEntity<?> insertNewProcess(@RequestBody AirProcess process){
        return new ResponseEntity<>(service.insert(process), HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<?> getListAddressByProfile(){
        List<AirProcess> list = new ArrayList<>();
        list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
