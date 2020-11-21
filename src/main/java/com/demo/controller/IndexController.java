package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    //只展示state为 1的用户，被删除的用户state 为-1  ps:删除的数据还在数据库中，界面上没有展示
    @GetMapping("/index")
    public String findAll(Model model){
        List<User> allUser = userService.findAllUser();
        model.addAttribute("users",allUser);
        return "user";
    }
    //添加用户
    @GetMapping("/toAdd")
    public String toAdd(){
        return "addUser";
    }
    @PostMapping("/add")
    public String addUser(User user){
        user.setState("1");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.insertUser(user);
        return "redirect:/index";
    }

    //删除用户
    @GetMapping("/delete")
    public String deleteUser(Long id){
        userService.deleteUser(id);
        return "redirect:/index";
    }

    //更新用户
    @GetMapping("/toUpdate")
    public String toUpdate(Long id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }
    @PostMapping("/update")
    public String update(User user){
        User userBefore = userService.findUserById(user.getId());
        user.setCreateTime(userBefore.getCreateTime());
        user.setUpdateTime(new Date());
        userService.updateUser(user);
        return "redirect:/index";
    }

}
