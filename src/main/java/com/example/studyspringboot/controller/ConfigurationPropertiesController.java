package com.example.studyspringboot.controller;

import com.example.studyspringboot.constant.PersonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/config")
public class ConfigurationPropertiesController {
    @Autowired
    private PersonConstant personConstant;

    @RequestMapping("/test")
    @ResponseBody
    public void testCon(){
        System.out.println(personConstant.toString());
    }
}
