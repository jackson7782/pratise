package com.example.demo.business;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PersonBusiness {
    @Autowired
    private PersonMapper personMapper;

    public int findTotalOfPerson() {
        return personMapper.findTotalOfPerson();
    }
}
