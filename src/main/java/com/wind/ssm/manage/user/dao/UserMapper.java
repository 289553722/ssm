package com.wind.ssm.manage.user.dao;

import com.wind.ssm.manage.user.vo.User;

import java.util.List;

/**
 * 用户映射接口
 */
public interface UserMapper {
    List<User> listUser(User user);
}
