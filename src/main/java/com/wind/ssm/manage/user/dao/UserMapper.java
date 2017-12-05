package com.wind.ssm.manage.user.dao;

import com.wind.ssm.manage.user.model.UserDo;

import java.util.List;

/**
 * 用户映射接口
 */
public interface UserMapper {
    List<UserDo> listUserDo(UserDo userDo);
}
