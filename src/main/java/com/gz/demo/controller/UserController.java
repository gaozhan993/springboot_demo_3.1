package com.gz.demo.controller;

import com.alibaba.fastjson.JSON;
import com.gz.demo.dto.UserDTO;
import com.gz.demo.pojo.User;
import com.gz.demo.pojo.UserRepository;
import com.gz.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    @GetMapping("getUser")
    public UserDTO getUser(){
        UserDTO userDTO = userInfoService.getUserDTO();
        return userDTO;
    }


    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping("/")
    public String root(){
        User user= new User();
        user.setUserName("李斯");
        user.setAge(12);
        userRepository.save(user);
        System.out.println(user.toString());
        return user.toString();
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<User> s = userRepository.findById(id);
        userRepository.deleteById(id);
        return s.get().toString() + "已经被删除";
    }

    @ResponseBody
    @RequestMapping("/update/{id}/{name}")
    public String update(@PathVariable Integer id, @PathVariable String name){
        /*获取以后，再重新赋值 其实有其他更好的办法*/
        User user = userRepository.findById(id).get();
        user.setUserName(name);
        userRepository.save(user);
        return user.toString();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public String find(@PathVariable Integer id){

        Optional<User> s = userRepository.findById(id);

        return s.get().toString();
    }

    @RequestMapping("goIndex")
    public String getIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("addUser")
    public String addUser(int userNo,String userName,int age){
        User user = new User(userNo,userName,age);
        System.out.println(user);
        userRepository.save(user);
        String message = "添加成功!";
        return message;
    }

    @ResponseBody
    @RequestMapping("del")
    public String delUserByUserNo(int userNo){
        Optional<User> s = userRepository.findById(userNo);
        userRepository.deleteById(userNo);
        return s.get().toString()+"已被删除";
    }

    @ResponseBody
    @RequestMapping("modify")
    public String modifyUserByUserNo(int userNo,String userName ,int age){
        User user = userRepository.findById(userNo).get();
        user.setUserName(userName);
        user.setAge(age);
        userRepository.save(user);
        return user.toString();
    }

    @ResponseBody
    @RequestMapping("find")
    public String getUserByUserNo(int userNo){
        User userTemp = new User();
        String json = JSON.toJSONString(userTemp);
        if(!userRepository.findById(userNo).toString().equals("Optional.empty")){
            User user = userRepository.findById(userNo).get();
            json = JSON.toJSONString(user);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("findAll")
    public String getAllUser(){
        List<User> s = userRepository.findAll();
        String json = JSON.toJSONString(s);
        return json;
    }
}
