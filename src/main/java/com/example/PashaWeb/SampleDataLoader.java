package com.example.PashaWeb;

import lombok.var;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SampleDataLoader {
    public static Set<Map.Entry<Object, Object>> readFile(String fileName) {
        var resource = new ClassPathResource(fileName);
        Properties itemsProps = new Properties();
        try {
            itemsProps.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemsProps.entrySet();
    }

}
