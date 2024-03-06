package com.tqt.airmon.controller;

import com.tqt.airmon.model.AirProject;
import com.tqt.airmon.model.dto.DashboardData;
import com.tqt.airmon.service.AirProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ViewController {

    @Autowired
    private AirProjectService projectService;

    @GetMapping()
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");
        DashboardData data = new DashboardData();
        data = projectService.setDataDashboard(data);
        view.addObject("dashboardData",data);
        return view;
    }

    @GetMapping("air-project")
    public String airProject(){
        return "air-project";
    }

    @GetMapping("/source")
    public String source(){
        return "source";
    }


    @GetMapping("profile")
    public String profile(){
        return "profile";
    }


    @GetMapping("wallet")
    public String wallet(){
        return "wallet";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
    @GetMapping("logout")
    public String logout(){
        return "redirect:/login";
    }

    @GetMapping("lauch-project/{id}")
    public ModelAndView lauchProject(@PathVariable Long id){
        ModelAndView view = new ModelAndView("lauch-project");
        AirProject project = projectService.getProjectById(id);
        view.addObject("project",project);
        return view;
    }

}
