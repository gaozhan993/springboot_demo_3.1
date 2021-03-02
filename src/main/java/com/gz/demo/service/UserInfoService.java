package com.gz.demo.service;

import com.gz.demo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    Logger log  = LoggerFactory.getLogger(UserInfoService.class);

    public UserDTO getUserDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(1);
        userDTO.setUserName("张三");
        log.info("UserInfoService-getUserDTO,出参，用户:{}",userDTO.getUserName());
        return  userDTO;
    }



}
