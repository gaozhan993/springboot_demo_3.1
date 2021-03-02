package com.gz.demo.pojo;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;

    @Column
    private String userName;
    private int age;

    public User() {

    }

    public User(int userNo,String userName, int age){
        this.userNo = userNo;
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
