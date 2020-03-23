package com.dyr.dao;

import com.dyr.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //获取用户列表
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //添加用户
    int addUser(User user);

    //使用map方法来添加用户
//    int addUser2(Map<String,Object> map);

    //更新用户信息
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //实现分页
    List<User> getUserByLimit(Map<String,Integer> map);



}
