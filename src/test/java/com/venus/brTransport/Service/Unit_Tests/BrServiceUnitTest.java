package com.venus.brTransport.Service.Unit_Tests;

import com.venus.brTransport.service.BrService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrServiceUnitTest {
    private final BrService brService = new BrService();

    @Test
    public void testCalculatePriceForMarchandisesGenerales() {
        Double result = brService.calculatePrice("MARCHANDISES GENERALES", 10.0, 5.0, 3.0, 500.0, 1000.0);
        assertEquals(0.2 * 10.0 * 5.0 * 3.0 * 1000.0 * 500.0 * 1 / 10000000, result);
    }

    @Test
    public void testCalculatePriceForTransportExceptionnel() {
        Double result = brService.calculatePrice("TRANSPORT EXCEPTIONNEL", 15.0, 7.0, 4.0, 700.0, 1200.0);
        assertEquals(0.3 * 15.0 * 7.0 * 4.0 * 1200.0 * 700.0 * 1 / 10000000, result);
    }

    @Test
    public void testCalculatePriceForMatieresDangereuses() {
        Double result = brService.calculatePrice("MATIERES DANGEREUSES", 12.0, 6.0, 2.0, 600.0, 1500.0);
        assertEquals(0.5 * 12.0 * 6.0 * 2.0 * 1500.0 * 600.0 * 1 / 10000000, result);
    }

    @Test
    public void testCalculatePriceForInvalidType() {
        Double result = brService.calculatePrice("Invalid Type", 10.0, 5.0, 3.0, 500.0, 1000.0);
        assertEquals(0.0, result); // This test ensures the default return value is 0.0 for an invalid type
    }
}