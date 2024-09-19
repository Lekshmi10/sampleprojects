package com.example.demo.dao;

import com.example.demo.model.TestModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TestDao {
    @Autowired
    EntityManager entityManager;

    public List<TestModel> fetchDataBase() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM testmodel", TestModel.class);
        currentSession.close();
        List<TestModel> getresultList = query.getResultList();
        return getresultList;
    }

    public String addData(TestModel testModel) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.save(testModel);
            currentSession.close();
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }

    }
}
