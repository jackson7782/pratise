package com.example.demo.datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
@Component
public class MysqlDatasource {
    static final String DATASOURCE_CONF_PATH = "datasource/mysqlDatasource.json";

    @Bean(name = "mysqlDatasource111")
    public DataSource dataSource() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File datasourceFile = new File(ClassLoader.getSystemResource(DATASOURCE_CONF_PATH).getFile());
        JsonNode jsonNode = mapper.readTree(datasourceFile);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jsonNode.path("JDBC_DRIVER").textValue());
        dataSource.setUrl(jsonNode.path("DB_URL").textValue());
        dataSource.setUsername(jsonNode.path("USER").textValue());
        dataSource.setPassword(jsonNode.path("PASS").textValue());
        return dataSource;
    }
}
