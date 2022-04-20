package com.example.demo.mapper;

import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper {
    public int findTotalOfPerson();
}
