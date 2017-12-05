package com.wind.ssm.manage.user.controller;

import com.wind.ssm.common.util.JsonUtil;
import com.wind.ssm.manage.user.model.UserDo;
import com.wind.ssm.manage.user.service.IUserService;
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
    private IUserService userService;
    
    @RequestMapping("/list")
    public String list(ModelMap map){
        UserDo user = new UserDo();
        List<UserDo> userList = userService.listUserDo(user);
        map.put("userList", userList);
        return "/user/list";
    }
    
    @RequestMapping("/sJson")
    @ResponseBody
    public Object sJson(){
        UserDo wind = new UserDo("wind","一行白鹭上青天",10);
        UserDo libai = new UserDo("libai","莫学我",3000);
        wind.setBirthDay(new Date());
        List<UserDo> userList = new ArrayList<UserDo>();
        userList.add(wind);
        userList.add(libai);
        return userList;
    }

    @RequestMapping("/oJson")
    @ResponseBody
    public String oJson(){
        UserDo wind = new UserDo("晶晶","789456123",987);
        UserDo libai = new UserDo("少少","嘻嘻中",1);
        libai.setBirthDay(new Date());
        List<UserDo> userList = new ArrayList<UserDo>();
        userList.add(wind);
        userList.add(libai);
        return JsonUtil.beanToJson(userList);
    }
}
