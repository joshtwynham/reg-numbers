package com.dvla.regnumbers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileReader {
    public static final String JSON_URL = "src/main/resources/registrationNumbers.json";

    public static List<RegistrationNumber> getRegistrationNumbers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(JSON_URL), new TypeReference<>(){});
    }
}
