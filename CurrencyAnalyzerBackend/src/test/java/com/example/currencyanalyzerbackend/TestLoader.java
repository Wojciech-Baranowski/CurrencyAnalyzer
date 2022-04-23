package com.example.currencyanalyzerbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class TestLoader {

    private static TestLoader TEST_LOADER = null;
    private final ObjectMapper objectMapper;

    private TestLoader(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static <T> List<T> loadTests(String resource, Class<T[]> classType){
        if(TEST_LOADER == null)
            TEST_LOADER = new TestLoader();
        try {
            File file = new File(requireNonNull(TestLoader.class.getClassLoader().getResource(resource)).getFile());
            return List.of(TEST_LOADER.objectMapper.readValue(file, classType));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
