package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.List;

@Component
public class TableInit {

    static final String USER = "root";
    static final String PASS = "123456";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

    public void init() throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        Connection conn = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            URL classPath = ClassLoader.getSystemResource("sql/initSql.sql");
            ReadSqlFileUtil readSqlFileUtil = new ReadSqlFileUtil();
            List<String> sqlList = readSqlFileUtil.getSqlFromFile(new File(classPath.getFile()));
            stmt=conn.createStatement();
            for (String sql : sqlList) {
                stmt.execute(sql);
                stmt.execute("commit");
            }
        } catch (Exception se) {

        } finally {
            stmt.close();
            conn.close();
        }
    }
}
