package com.tqt.airmon.controller;

import com.tqt.airmon.model.Source;
import com.tqt.airmon.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source/")
public class SourceAPI {


    @Autowired
    private SourceService sourceService;


    @GetMapping("test")
    public String testInsert(){
        Source source = new Source();
        source.setName("UG");
        source.setLink("https://t.me/AirdropUGChannel");
        sourceService.insert(source);
        return "Good";
    }

}
