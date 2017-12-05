package com.wind.ssm.manage.user.service;

import com.wind.ssm.manage.user.model.UserDo;

import java.util.List;

public interface IUserService {
    // 查询用户列表
    List<UserDo> listUserDo(UserDo user);
}
