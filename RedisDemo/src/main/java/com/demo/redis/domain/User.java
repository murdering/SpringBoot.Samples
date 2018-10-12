package com.demo.redis.domain;

import java.io.Serializable;

public class User implements Serializable {
    private  static final long serialVerisonUID = -1L;

    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public User(String username, Integer age){
        this.username = username;
        this.age = age;
    }
}
