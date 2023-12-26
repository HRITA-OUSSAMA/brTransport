package com.venus.brTransport.Service.Unit_Tests;

import com.venus.brTransport.model.Responsable;
import com.venus.brTransport.repository.ResponsableRepository;
import com.venus.brTransport.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AdminServiceUnitTest {
    @Mock
    private ResponsableRepository responsableRepository;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetResponsables() {
        // Mocking data for testing
        List<Responsable> responsablesList = new ArrayList<>();
        responsablesList.add(new Responsable("123456", "Male", "John", "Doe", "john.doe@example.com", "password"));
        responsablesList.add(new Responsable("789012", "Female", "Jane", "Smith", "jane.smith@example.com", "pass123"));

        // Mocking repository method behavior
        when(responsableRepository.findAll()).thenReturn(responsablesList);

        // Testing the service method
        Iterable<Responsable> result = adminService.getResponsables();

        // Verifying the result
        assertEquals(responsablesList.size(), ((List<Responsable>) result).size());
    }

    @Test
    public void testGetResponsableByEmail() {
        // Mocking data for testing
        Responsable sampleResponsable = new Responsable("123456", "Male", "John", "Doe", "john.doe@example.com", "password");

        // Mocking repository method behavior
        when(responsableRepository.findByEmail(anyString())).thenReturn(sampleResponsable);

        // Testing the service method with a sample email
        Responsable result = adminService.getResponsableByEmail("john.doe@example.com");

        // Verifying the result
        assertEquals(sampleResponsable.getEmail(), result.getEmail());
        // Add more assertions for other properties as needed
    }
}