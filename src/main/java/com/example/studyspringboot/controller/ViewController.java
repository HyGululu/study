package com.example.studyspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller注解相关的测试
 */

@Controller
public class ViewController {
    public static final String PAGE="view";

    //不带数据直接返回页面，String返回
    @RequestMapping("view")//完整的url地址：http://localhost:8080/view
    public String view(){
        return PAGE;
    }

    //带数据返回页面，ModelAndView对象返回
    @RequestMapping("data")
    public ModelAndView data(){
        ModelAndView view = new ModelAndView(PAGE);
        view.addObject("str1","我是yy");
        view.addObject("str2","我是张三");
        return view;
    }

}
/*
@Controller
控制器类

@Controller+@RequestMapping+

 */