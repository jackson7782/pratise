package com.example.demo;

import com.example.demo.util.ReadSqlFileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class test {

    public static void main(String[] args) throws IOException {
        ReadSqlFileUtil readSqlFileUtil=new ReadSqlFileUtil();
        URL classPath=ClassLoader.getSystemResource("sql/initSql.sql");
        System.out.println(classPath);
        File file=new File(classPath.getFile());
        readSqlFileUtil.getSqlFromFile(file).forEach(e-> System.out.println(e));
        System.out.println(ClassLoader.getSystemResource(""));
    }
}
