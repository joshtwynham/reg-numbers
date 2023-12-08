package com.dvla.regnumbers;

import com.dvla.regnumbers.registrationnumber.RegistrationNumberManager;

import java.io.IOException;

import static com.dvla.regnumbers.utils.JsonFileReader.getRegistrationNumbers;

public class ApplicationInitializer {
    public static void main(String[] args) throws IOException {
        RegistrationNumberManager registrationNumberManager = new RegistrationNumberManager(getRegistrationNumbers());
    }
}