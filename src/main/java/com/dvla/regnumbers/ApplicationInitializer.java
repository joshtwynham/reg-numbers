package com.dvla.regnumbers;

import java.io.IOException;

import static com.dvla.regnumbers.JsonFileReader.getRegistrationNumbers;

public class ApplicationInitializer {
    public static void main(String[] args) throws IOException {
        RegistrationNumberManager registrationNumberManager = new RegistrationNumberManager(getRegistrationNumbers());
    }
}