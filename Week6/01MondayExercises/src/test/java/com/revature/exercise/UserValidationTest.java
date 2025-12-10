package com.revature.exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidationTest {
    private static UserValidation userValidation;

    @BeforeAll
    public static void setUp() {
        userValidation = new UserValidation();
    }

    @Test
    public void validateEmail_nullEmail_throwException() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () -> userValidation.validateEmail(null));
        assertEquals("Email cannot be null", actualException.getMessage());
    }
}
