package com.example.demo.util;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class ReadSqlFileUtil {
    @SneakyThrows
    public List<String> getSqlFromFile(File file) throws IOException {
        List<String> result = new ArrayList<>();
        FileInputStream inFile = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inFile));
        String line = null;
        StringBuilder sb = new StringBuilder("");
        while ((line = reader.readLine()) != null) {
            if (line.equals("/")) {
                result.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append("\n");
                sb.append(line);
            }
        }
        reader.close();
        return result;
    }
}
