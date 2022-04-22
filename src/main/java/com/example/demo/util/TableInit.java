package com.example.demo.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class TableInit {
    @Autowired
    DataSource dataSource;
    static final String DATASOURCE_CONF_PATH = "datasource/mysqlDatasource.json";

    @SneakyThrows
    public void init() throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            File datasourceFile = new File(ClassLoader.getSystemResource(DATASOURCE_CONF_PATH).getFile());
            JsonNode jsonNode = mapper.readTree(datasourceFile);
            Iterator<String> stringIterator = jsonNode.fieldNames();
            while (stringIterator.hasNext()) {
                System.out.println(stringIterator.next());
            }
            // 注册 JDBC 驱动
            Class.forName(jsonNode.path("JDBC_DRIVER").textValue());
            // 打开链接
            conn = DriverManager.getConnection(jsonNode.path("DB_URL").textValue(), jsonNode.path("USER").textValue(), jsonNode.path("PASS").textValue());
//            conn=dataSource.getConnection();
            String filePath = ClassLoader.getSystemResource("sql").getPath();
            File file = new File(filePath);      //获取其file对象
            ReadSqlFileUtil readSqlFileUtil = new ReadSqlFileUtil();
            List<String> sqlList = new ArrayList<>();
            for (File sqlFile : file.listFiles()) {
                sqlList = readSqlFileUtil.getSqlFromFile(sqlFile);
                stmt = conn.createStatement();
                for (String sql : sqlList) {
                    stmt.execute(sql);
                    stmt.execute("commit");
                }
            }
        } catch (Exception se) {

        } finally {
            stmt.close();
            conn.close();
        }
    }
}
