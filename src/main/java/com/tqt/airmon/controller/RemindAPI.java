package com.tqt.airmon.controller;

import com.tqt.airmon.model.Remind;
import com.tqt.airmon.service.RemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/remind")
public class RemindAPI {

    @Autowired
    private RemindService remindService;

    @PostMapping("")
    public ResponseEntity<?> insertRemind(@RequestBody Remind remind){
        return new ResponseEntity<>(remindService.insert(remind), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getRemindByProjectId(@RequestParam Long projectId){
        return new ResponseEntity<>(remindService.getByProjectId(projectId), HttpStatus.OK);
    }
}
