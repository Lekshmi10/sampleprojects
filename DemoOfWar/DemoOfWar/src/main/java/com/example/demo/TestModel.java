package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TestModel")
@Entity(name = "TestModel")
public class TestModel {
    @Id
    @Column(name = "id")
    private int id;
    @Lob
    @Column(name = "testData")
    private String testData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }
}
