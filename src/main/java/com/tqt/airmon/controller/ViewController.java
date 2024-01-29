package com.tqt.airmon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping()
    public String index(){
        return "index";
    }

    @GetMapping("air-project")
    public String airProject(){
        return "index";
    }

    @GetMapping("/source")
    public String source(){
        return "source";
    }


    @GetMapping("profile")
    public String profile(){
        return "index";
    }


    @GetMapping("wallet")
    public String wallet(){
        return "index";
    }

}
