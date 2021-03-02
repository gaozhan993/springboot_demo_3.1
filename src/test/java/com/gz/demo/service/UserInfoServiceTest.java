package com.gz.demo.service;

import com.gz.demo.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoServiceTest {

    private Logger log = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void getUserDTO() {
        UserDTO userDTO = userInfoService.getUserDTO();
        log.info("UserInfoServiceTest-getDTO,出参，用户ID：{}",userDTO.getUserID());
        log.info("UserInfoServiceTest-getDTO,出参，用户姓名：{}",userDTO.getUserName());
    }
}