package com.example.mybatis.domain;

import java.io.Serializable;

public class User implements Serializable {
    private  static final long serialVerisonUID = -1L;

    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
