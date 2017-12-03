package com.wind.ssm.manage.user.controller;

import com.wind.ssm.common.util.JsonUtil;
import com.wind.ssm.manage.user.service.UserService;
import com.wind.ssm.manage.user.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Resource
    private UserService userService;
    
    @RequestMapping("/list")
    public String list(ModelMap map){
        User user = new User();
        List<User> userList = userService.listUser(user);
        map.put("userList", userList);
        return "/user/list";
    }
    
    @RequestMapping("/sJson")
    @ResponseBody
    public Object sJson(){
        User wind = new User("wind","一行白鹭上青天",10);
        User libai = new User("libai","莫学我",3000);
        wind.setBirthDay(new Date());
        List<User> userList = new ArrayList<User>();
        userList.add(wind);
        userList.add(libai);
        return userList;
    }

    @RequestMapping("/oJson")
    @ResponseBody
    public String oJson(){
        User wind = new User("晶晶","789456123",987);
        User libai = new User("少少","嘻嘻中",1);
        libai.setBirthDay(new Date());
        List<User> userList = new ArrayList<User>();
        userList.add(wind);
        userList.add(libai);
        return JsonUtil.beanToJson(userList);
    }
}
