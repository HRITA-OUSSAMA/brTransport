package com.venus.brTransport.Service.Unit_Tests.service;


import com.fasterxml.classmate.Annotations;
import com.venus.brTransport.model.*;
import com.venus.brTransport.repository.OperationRepository;
import com.venus.brTransport.service.LieuService;
import com.venus.brTransport.service.OperationService;
import com.venus.brTransport.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OperationServiceUnitTest {
    @InjectMocks
    private OperationService operationService;

    @Mock
    private OperationRepository operationRepository;

    @Mock
    private UserService userService;

    @Mock
    private LieuService lieuService;

    @Test
    public void testSaveOperation() {
        Operation operationToSave = new Operation();
        operationToSave.setOperation_id(1);
        operationToSave.setStatus("oui");
        operationToSave.setLieu_id(1);
        operationToSave.setUser_id(1);

        operationService.saveOperation(operationToSave);

        // Verify that the OperationRepository's save method was called with the correct parameter
        verify(operationRepository).save(operationToSave);
    }


    @Test
    public void testGetOperationUser() {
        int userId = 1;
        User mockUser = new User();
        mockUser.setUser_id(1);
        when(userService.getUserById(userId)).thenReturn(mockUser);

        List<Operation> operations = operationService.getOperationUser(userId);

        assertNotNull(operations);
        // Add assertions based on your data

        verify(userService).getUserById(userId);
    }


    @Test
    public void testIntegrationGetOperationAdminCards() {
        // Create dummy operations
        Operation operation1 = new Operation();
        Operation operation2 = new Operation();
        operation1.setUser_id(1);
        operation1.setStatus("oui");
        operation1.setUser_id(1);
        operation1.setLieu_id(1);
        operation2.setUser_id(2);
        operation2.setStatus("non");
        operation2.setUser_id(1);
        operation2.setLieu_id(2);

        // Set up the mock to return dummy operations
        when(operationRepository.findAll()).thenReturn(Arrays.asList(operation1, operation2));

        // Set up the mock to return a dummy user for any user ID
        int userId = 1;
        when(userService.getUserById(userId)).thenReturn(new User());

        // Call the service method
        List<OperationAdminCard> operationAdminCards = operationService.getOperationAdminCards();

        // Verify that the repository method was called exactly once
        verify(operationRepository).findAll();

        // Verify that the user service method was called exactly once with the specified user ID
        verify(userService, times(2)).getUserById(userId);

        // Add other assertions based on your data
        assertNotNull(operationAdminCards);
    }


}
