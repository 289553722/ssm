package com.wind.ssm.manage.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    
    private static final Logger logger = LoggerFactory.getLogger(Index.class);
    
    @RequestMapping("/index")
    public String index(ModelMap map){
        map.put("name", "首页");
        return "/index";
    }
}
