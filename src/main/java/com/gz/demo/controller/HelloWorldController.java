package com.gz.demo.controller;

import com.gz.demo.pojo.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class HelloWorldController {

    private Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("select")
    public List<Emp> getEmp(){
        String sql = "SELECT empno,ename,job FROM emp";
        List list = new ArrayList();
        list = jdbcTemplate.queryForList(sql);
        return list;
    }

 /*   @GetMapping("index")
    public String index(){
        log.info("helloWorld-index-用于测试info");
        log.error("HelloWorld-index-用于测试error");
        log.debug("helloWorld-index-用于测试debug");
        return "Hello World ! This is a Spring-Boot Project devtools test";
    }*/

    @GetMapping("insert")
    public String insert(){
        String sql  =  "INSERT INTO dept  (deptno,dname,loc)  values (50,'前台',''China)";
        jdbcTemplate.execute(sql);
        return "插入完成";
    }



}
