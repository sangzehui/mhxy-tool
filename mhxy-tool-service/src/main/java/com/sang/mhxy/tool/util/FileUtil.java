package com.sang.mhxy.tool.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> getListFromFile(String fileName) {
        Resource resource = new ClassPathResource(fileName);
        List<String> list = new ArrayList<>();
        list.add("0");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()))) {
            while(bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
