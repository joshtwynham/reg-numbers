package com.dvla.regnumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.dvla.regnumbers.JsonFileReader.getRegistrationNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationNumberManagerTest {
    RegistrationNumberManager registrationNumberManager;
    List<RegistrationNumber> registrationNumbers;

    @BeforeEach
    public void setup() throws IOException {
        registrationNumbers = getRegistrationNumbers();
        registrationNumberManager = new RegistrationNumberManager(registrationNumbers);
    }

    @Test
    public void givenRegistrationNumbers_whenGetTotalQuantity_thenReturnCorrectAmount() {
        int totalQuantityOfRegistrationNumbers = registrationNumberManager.getTotalQuantityOfRegistrationNumbers();
        assertEquals(3, totalQuantityOfRegistrationNumbers);
    }

    @Test
    public void givenExistingVehicleId_whenGetVehicleId_thenVehicleIdReturned() {
        Optional<Integer> vehicleId = registrationNumberManager.getVehicleIdFor(registrationNumbers.get(0).getValue());
        assertEquals(registrationNumbers.get(0).getVehicleId(), vehicleId.orElse(null));
    }

    @Test
    public void givenNullVehicleId_whenGetVehicleId_thenOptionalEmptyReturned() {
        Optional<Integer> vehicleId = registrationNumberManager.getVehicleIdFor(registrationNumbers.get(2).getValue());
        assertEquals(Optional.empty(), vehicleId);
    }
}
