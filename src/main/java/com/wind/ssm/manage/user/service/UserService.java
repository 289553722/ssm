package com.wind.ssm.manage.user.service;

import com.wind.ssm.manage.user.dao.UserMapper;
import com.wind.ssm.manage.user.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    
    public List<User> listUser(User user){
        return userMapper.listUser(user);
    }
}
