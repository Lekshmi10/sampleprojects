package com.example.demo.service;

import com.example.demo.dao.TestDao;
import com.example.demo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TestService {
    @Autowired
    TestDao testDao;

    public List<TestModel> fetchDB() {
        return testDao.fetchDataBase();
    }

    @Transactional
    public String addToDB(TestModel testModel) {
        return testDao.addData(testModel);
    }
}
