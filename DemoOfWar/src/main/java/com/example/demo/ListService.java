package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ListService {
    @Autowired
    ListDao listDao;

    @Transactional
    public ListModel saveData(ListModel listModel) {
        return listDao.saveData(listModel);
    }

}
