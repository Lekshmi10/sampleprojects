package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    ListService listService;

    @GetMapping("/")
    public String test1() {
        return "success";
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @PostMapping("/saveTicketDetails")
    public ListModel save(@RequestBody ListModel listModel) {
        return listService.saveData(listModel);
    }
}
