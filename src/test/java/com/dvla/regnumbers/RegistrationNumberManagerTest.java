package com.dvla.regnumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.dvla.regnumbers.ApplicationInitializer.REG_NUMBER_ONE;
import static com.dvla.regnumbers.ApplicationInitializer.REG_NUMBER_TWO;
import static com.dvla.regnumbers.ApplicationInitializer.REG_NUMBER_THREE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationNumberManagerTest {
    RegistrationNumberManager registrationNumberManager;

    @BeforeEach
    public void setup() {
        List<RegistrationNumber> registrationNumbers = new ArrayList<>();

        registrationNumbers.add(REG_NUMBER_ONE);
        registrationNumbers.add(REG_NUMBER_TWO);
        registrationNumbers.add(REG_NUMBER_THREE);

        registrationNumberManager = new RegistrationNumberManager(registrationNumbers);
    }

    @Test
    public void givenRegistrationPlates_whenGetTotalQuantity_thenReturnCorrectAmount() {
        int totalQuantityOfRegistrationNumbers = registrationNumberManager.getTotalQuantityOfRegistrationNumbers();
        assertEquals(3, totalQuantityOfRegistrationNumbers);
    }

    @Test
    public void givenExistingVehicleId_whenGetVehicleId_thenVehicleIdReturned() {
        Optional<Integer> vehicleId = registrationNumberManager.getVehicleIdFor(REG_NUMBER_ONE.getValue());
        assertEquals(REG_NUMBER_ONE.getVehicleId(), vehicleId.orElse(null));
    }

    @Test
    public void givenNullVehicleId_whenGetVehicleId_thenOptionalEmptyReturned() {
        Optional<Integer> vehicleId = registrationNumberManager.getVehicleIdFor(REG_NUMBER_THREE.getValue());
        assertEquals(Optional.empty(), vehicleId);
    }
}
