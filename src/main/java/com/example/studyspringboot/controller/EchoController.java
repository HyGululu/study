package com.example.studyspringboot.controller;

import com.example.studyspringboot.constant.PersonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/echo")
public class EchoController {
    @Autowired
    private PersonConstant personConstant;

    @RequestMapping(value = "/getter/pattern1",method = RequestMethod.GET)
    @ResponseBody
    public PersonConstant testCon(){
        return personConstant;
    }
}
