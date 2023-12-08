package com.dvla.regnumbers;

import com.dvla.regnumbers.registrationnumber.RegistrationNumber;
import com.dvla.regnumbers.registrationnumber.RegistrationNumberManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.dvla.regnumbers.utils.JsonFileReader.getRegistrationNumbers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationNumberManagerTest {
    public static final String NON_EXISTENT_REGISTRATION = "N0 EX1ST33";

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

    @Test
    public void givenNonExistentRegistrationNumber_whenGetVehicleId_thenOptionalEmptyReturned() {
        Optional<Integer> vehicleId = registrationNumberManager.getVehicleIdFor(NON_EXISTENT_REGISTRATION);
        assertEquals(Optional.empty(), vehicleId);
    }
}
