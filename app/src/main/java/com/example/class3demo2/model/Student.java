package com.example.class3demo2.model;

public class Student {
    public String name;
    public String id;
    public String phone;
    public String address;
    public String avatarUrl;
    public Boolean cb;

    public Student(String name, String id, String avatarUrl, Boolean cb, String phone,String address ) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.cb = cb;
        this.address = address;
        this.phone = phone ;
    }
}
