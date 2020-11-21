package com.demo.service;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //增
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    //删
    public void deleteUser(Long id){
        userMapper.deleteUser(id);
    }

    //改
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    //根据电话查某一用户
    public User findUserByMobile(String mobile){
        User user = userMapper.findUserByMobile(mobile);
        return user;
    }
    //根据id查询用户
    public User findUserById(Long id){
        User user = userMapper.findUserById(id);
        return user;
    }

    //查询所有用户
    public List<User> findAllUser(){
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }
}
