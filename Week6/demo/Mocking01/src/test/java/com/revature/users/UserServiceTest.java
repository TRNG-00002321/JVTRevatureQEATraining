package com.revature.users;

import com.revature.users.dao.UserRepository;
import com.revature.users.model.User;
import com.revature.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock // Creates the mocked UserRepository
    private UserRepository repository;

    @InjectMocks // Injects the mocked UserRepository into UserService
    private UserService service;

    private User existingUser;
    private User newUser;

    @BeforeEach
    public void setUp() {
        existingUser = new User(1L, "Imran R", "imran@email.com");
        newUser = new User(null, "Sunni M", "sunni@email.com");
    }

    @Test
    public void testUserById_positive() {
        // Arrange
        when(repository.findById(1L)).thenReturn(existingUser);

        // Act
        User foundUser = service.getUserById(1L);

        // Assert
        assertEquals("Imran R", foundUser.getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testUserById_negative() {
        when(repository.findById(null)).thenReturn(newUser);
        User foundUser = service.getUserById(null);
        assertEquals("Sunni M", foundUser.getName());
        verify(repository, times(1)).findById(null);
    }

    @Test
    public void testRegister_positive() {
        when(repository.findByEmail("sunni@email.com")).thenReturn(null);
        boolean isNewUser = service.register(newUser);
        assertTrue(isNewUser);
        verify(repository, times(1)).findByEmail(newUser.getEmail());
    }

    @Test
    public void testRegister_negative() {
        when(repository.findByEmail("imran@email.com")).thenReturn(existingUser);
        boolean isNewUser = service.register(existingUser);
        assertFalse(isNewUser);
        verify(repository, times(1)).findByEmail(existingUser.getEmail());
    }
}
