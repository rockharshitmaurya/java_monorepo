package com.crudWithAllDb.allDb.postgreSQl.entity;

public class Student{
    private String name;
    private String city;

    private Integer id;

    public Student(String name, String city, Integer id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public Student(){
        super();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

