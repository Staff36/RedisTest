package com.example.redis2.controller;

import com.example.redis2.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    StudentsService service;

    @GetMapping("/{id}")
    public String getStudent(@PathVariable String id) {
        String s = service.findById(id);
        String resp;
        if (s == null){
            resp = "Token with id: " + id +" not found";
        } else {
            resp ="Token with id: " + id +" is: " + s;
        }
        return resp;
    }

    @GetMapping("/{id}/put")
    public void put(@PathVariable String id) {
        service.put(id, 10L);
    }

    @GetMapping("/{id}/bool")
    public String hasKey(@PathVariable String id) {
        String response = "FALSE БЛЯТЬ";
        if (service.hasKey(id)) {
            response = "TRUE БЛЯТЬ";
        }
        return response;
    }
}
