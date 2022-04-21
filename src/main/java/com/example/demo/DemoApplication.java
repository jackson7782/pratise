package com.example.demo;

import com.example.demo.util.TableInit;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(DemoApplication.class, args);
        TableInit tableInit = new TableInit();
        tableInit.init();
    }

}
