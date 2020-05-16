package com.demo.controller;


import com.demo.service.DemoService;
import com.demo.service.DemoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DemoController {

    private static final Logger logger = LogManager.getLogger(DemoServiceImpl.class);

//    @Autowired
//    EmployeeManager employeeManager;

    @Autowired(required=true)
    DemoService demoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String displayStudents(ModelMap model) {
        try{
            model.addAttribute("students", demoService.getAllStudents());
        }catch (Exception e){
            logger.debug(e.getMessage());
            logger.debug("EXCEPTION!");
            model.addAttribute("students", "Empty list!");
        }

        return "hello";
    }

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public String displayGenres(ModelMap model){
        try{
            logger.debug("GENRE LIST: " + demoService.getDemoObject("2"));
        }catch (Exception e){
            logger.debug("EXCEPTION: " + e.getMessage());
        }
        return "hello";
    }
}