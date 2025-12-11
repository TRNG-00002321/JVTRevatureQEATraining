package com.revature.firstmock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  // Enables Mockito annotations
class UserServiceTest {

    @Mock
    private UserRepository repository;  // Mock the dependency

    @Mock
    private EmailClient emailClient;  // Mock the dependency

    @InjectMocks
    private UserService userService;  // Inject mocks automatically

    private User savedUser;
    private User nullName;
    private User nullEmail;
    private User badEmail;
    private List<User> expectedUserList;

    @BeforeEach
    void setUp() {
        savedUser = new User(27L, "Megan", "megan@test.com");
        nullName = new User(null, "guy@test.com");
        nullEmail = new User("Person", null);
        badEmail = new User("Grug", "oogieBoogie_dot_kerm");
        expectedUserList = null;
    }

    @Test
    void getUser_existingUser_returnsUser() {
        // Arrange: Configure the mock
        User expectedUser = new User("John", "john@test.com");
        expectedUser.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(expectedUser));

        // Act: Call the method under test
        User actualUser = userService.getUser(1L);

        // Assert: Verify the result
        assertEquals(expectedUser, actualUser);
        assertEquals("John", actualUser.getName());
    }

    @Test
    void getUser_nonExistentUser_throwsException() {
        // Arrange: Mock returns empty Optional
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserService.UserNotFoundException.class, () -> {
            userService.getUser(999L);
        });
    }

    @Test
    void createUser_successfulUserCreation_returnsId() {
        when(repository.existsByEmail(savedUser.getEmail())).thenReturn(false);
        when(repository.save(savedUser)).thenReturn(savedUser);

        User actualUser = userService.createUser(savedUser);

        assertEquals(savedUser, actualUser);
    }

    @Test
    void createUser_duplicateEmail_throwsException() {
        when(repository.existsByEmail(savedUser.getEmail())).thenReturn(true);
        assertThrows(UserService.DuplicateUserException.class, () -> userService.createUser(savedUser));
    }

    @Test
    void createUser_nullName_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(nullName));
    }

    @Test
    void createUser_invalidEmail_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(badEmail));
    }

    @Test
    void getActiveUsers_activeUserBase_returnsList() {
        expectedUserList = new ArrayList<>();
        expectedUserList.add(savedUser);
        when(repository.findAllActive()).thenReturn(expectedUserList);
        assertSame(expectedUserList, userService.getActiveUsers());
    }

    @Test
    void getActiveUsers_noActiveUsers_returnsNull() {
        when(repository.findAllActive()).thenReturn(null);
        assertNull(userService.getActiveUsers());
    }

    @Test
    void getUserCount_usersExists_returnsCount() {
        when(repository.count()).thenReturn(100L);
        assertEquals(100L, userService.getUserCount());
    }

    @Test
    void getUserCount_noExistingUsers_returnsZero() {
        when(repository.count()).thenReturn(0L);
        assertEquals(0L, userService.getUserCount());
    }
}
