package com.wind.ssm.manage.user.service.impl;

import com.wind.ssm.manage.user.dao.UserMapper;
import com.wind.ssm.manage.user.model.UserDo;
import com.wind.ssm.manage.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private UserMapper userMapper;
    
    public List<UserDo> listUserDo(UserDo user){
        return userMapper.listUserDo(user);
    }
}
