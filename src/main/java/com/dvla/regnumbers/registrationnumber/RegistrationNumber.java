package com.dvla.regnumbers.registrationnumber;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegistrationNumber {
    private String value;
    private int year;
    private Integer vehicleId;
}
