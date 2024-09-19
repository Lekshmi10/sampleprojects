package com.example.demo;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ListDao {

    @Autowired
    EntityManager entityManager;


    public ListModel saveData(ListModel listModel) {

        TestModel testModel = new TestModel();
        testModel.setId(2);
        testModel.setTestData(listModel.toString());
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(testModel);
        currentSession.close();
        return listModel;

    }

}
