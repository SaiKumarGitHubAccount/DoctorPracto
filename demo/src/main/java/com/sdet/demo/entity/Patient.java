package com.sdet.demo.entity;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String disease;
    private int age;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
