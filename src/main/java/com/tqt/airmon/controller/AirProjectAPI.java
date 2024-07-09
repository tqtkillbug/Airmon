package com.tqt.airmon.controller;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.service.AirProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> getListProject(
            @RequestParam("draw") int draw,
            @RequestParam("start") int start,
            @RequestParam("length") int length,
            @RequestParam("search[value]") String searchValue,
            @RequestParam("order[0][column]") int orderColumn,
            @RequestParam("order[0][dir]") String orderDir){

        String[] columnNames = { "id", "name", "description", "note", "linkSource", "status", "source.name", "process.length" };
        String orderBy = columnNames[orderColumn];

        Page<AirProject> page = airProjectService.getAirProjects(PageRequest.of(start / length, length, Sort.by(Sort.Direction.fromString(orderDir), orderBy)), searchValue);

        Map<String, Object> response = new HashMap<>();
        response.put("draw", draw);
        response.put("recordsTotal", page.getTotalElements());
        response.put("recordsFiltered", page.getTotalElements());
        response.put("data", page.getContent());

        return ResponseEntity.ok(response);
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
    public ResponseEntity<?> updateProject(@PathVariable Long id, @RequestBody AirProject project) {
        AirProject updateWallet = airProjectService.updateProject(id, project);
        return ResponseEntity.ok(updateWallet);
    }

}
