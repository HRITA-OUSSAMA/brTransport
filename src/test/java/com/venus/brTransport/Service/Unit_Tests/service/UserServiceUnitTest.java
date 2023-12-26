package com.venus.brTransport.Service.Unit_Tests.service;


import com.venus.brTransport.model.User;
import com.venus.brTransport.repository.UserRepository;
import com.venus.brTransport.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;


@SpringBootTest
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetUserById() {
        // Créez un mock User pour simuler le retour de la méthode findById
        User mockUser = new User();
        mockUser.setUser_id(1);
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));

        // Appelez la méthode du service et effectuez des assertions
        User user = userService.getUserById(1);
        assertNotNull(user);
        // Add more assertions based on your data

        // Vérifiez que la méthode du repository a été appelée avec les bons paramètres
        verify(userRepository).findById(1);

    }

    @Test
    public void testGetUsers() {
        // Mock repository behavior
        User user1 = new User();
        user1.setUser_id(1);
        user1.setNom("ahmed");
        user1.setPrenom("ahmed");

        User user2 = new User();
        user2.setUser_id(2);
        user2.setNom("you");
        user2.setPrenom("you");

        List<User> mockUsers = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(mockUsers);

        // Call the method in userService
        Iterable<User> users = userService.getUsers();

        // Assertions based on your mock data
        assertNotNull(users);

        List<User> userList = StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(2, userList.size());
        assertEquals("ahmed", userList.get(0).getNom());
        assertEquals("ahmed", userList.get(0).getPrenom());
        assertEquals("you", userList.get(1).getNom());
        assertEquals("you", userList.get(1).getPrenom());
        // Add more assertions based on your data

        verify(userRepository).findAll();
    }
    @Test
    public void testSaveUser() {
        User userToSave = new User(/* set user properties */);
        when(userRepository.save(userToSave)).thenReturn(userToSave);

        User savedUser = userService.saveUser(userToSave);

        assertNotNull(savedUser);
        // Add assertions based on your data

        verify(userRepository).save(userToSave);
    }

    @Test
    public void testGetUserMail() {
        String email = "test@example.com";
        User mockUser = new User();
        when(userRepository.findByMail(email)).thenReturn(mockUser);

        User user = userService.getUserMail(email);

        assertNotNull(user);
        // Add assertions based on your data

        verify(userRepository).findByMail(email);
    }
    

    @Test
    public void testDeleteUserById() {
        int userIdToDelete = 1;

        userService.deleteUserById(userIdToDelete);

        // Verify that the UserRepository's deleteById method was called with the correct parameter
        verify(userRepository).deleteById(userIdToDelete);
    }

}
