package com.example.demo.controller;

import com.example.demo.business.PersonBusiness;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonBusiness personBusiness;

    @GetMapping("/people")
    public int getAllPerson() {
        return personBusiness.findTotalOfPerson();
    }
}
