package com.example.demo;

import com.example.demo.model.TestModel;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    TestService testService;

    @GetMapping("/getDB")
    public TestModel fetchDB() {
        return testService.fetchDB().get(0);
    }

    @PostMapping("/addDB")
    public String addData(@RequestBody TestModel testModel) {
        return testService.addToDB(testModel);
    }


}
