package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserMapper {
        List<User> selectUser();

        //根据id查询用户
        User selectUserById(int id);

        //添加用户
        int addUser(User user);

        //改
        int updateUser(User user);

        //删
        int deleteUser(int id);
}
