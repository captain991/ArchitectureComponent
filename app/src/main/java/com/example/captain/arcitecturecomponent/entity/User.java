package com.example.captain.arcitecturecomponent.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by captain on 2018/9/24 下午11:31}.
 */
@Entity
public class User {
    @PrimaryKey
    private int id;
    private String name;
    private String pwd;
    private int age;

    public User(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
