package com.dvla.regnumbers;

import java.util.ArrayList;
import java.util.List;

public class ApplicationInitializer {

    public static final RegistrationNumber REG_NUMBER_ONE = new RegistrationNumber("AB01 CDE", 2001, 12345);
    public static final RegistrationNumber REG_NUMBER_TWO = new RegistrationNumber("FG02 HJK", 2002, 67890);
    public static final RegistrationNumber REG_NUMBER_THREE = new RegistrationNumber("L33T H4X0R", 2022, null);
    public static void main(String[] args) {
        List<RegistrationNumber> registrationNumbers = new ArrayList<>();

        registrationNumbers.add(REG_NUMBER_ONE);
        registrationNumbers.add(REG_NUMBER_TWO);
        registrationNumbers.add(REG_NUMBER_THREE);

        RegistrationNumberManager registrationNumberManager = new RegistrationNumberManager(registrationNumbers);
    }
}