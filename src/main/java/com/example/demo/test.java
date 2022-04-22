package com.example.demo;

import com.example.demo.util.ReadSqlFileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class test {
    static final String DATASOURCE_CONF_PATH = "datasource/mysqlDatasource.json";
    public static void main(String[] args) throws IOException {
        String file = ClassLoader.getSystemResource(DATASOURCE_CONF_PATH).getFile();
        System.out.println(file);
    }
}
