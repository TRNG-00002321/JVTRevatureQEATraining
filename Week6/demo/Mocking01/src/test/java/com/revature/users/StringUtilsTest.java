package com.revature.users;

import com.revature.users.utils.StringUtils;
import com.revature.users.model.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    public void testReverse_positive() {
        String word = "Hello World!";
        String expectedResult = "!dlroW olleH";
        String actualResult = StringUtils.reverse(word);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse_negative() {
        assertNull(StringUtils.reverse(null));
    }

    @Test
    public void testIsEmpty_emptyString_positive() {
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void testIsEmpty_notEmptyString_positive() {
        assertFalse(StringUtils.isEmpty("Hello World!"));
    }

    @Test
    public void testIsEmpty_negative() {
        assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    public void testFindFirst_positive() {
        String[] words = {"coffee", "apple", "backpack", "composition", "competition"};
        String prefix = "comp";
        String firstFound = StringUtils.findFirst(words, prefix);
        assertEquals(words[3], firstFound);
    }

    @Test
    public void testFindFirst_prefixNotFound_negative() {
        String[] words = {""};
        assertNull(StringUtils.findFirst(words, "pre"));
    }

    @Test
    public void testFindFirst_nullItems_negative() {
        assertNull(StringUtils.findFirst(null, "post"));
    }

    @Test
    public void testSplit_positive() {
        String phrase = "1, 2, 3, 4, 5";
        String[] expectedResult = {"1", "2", "3", "4", "5"};
        String[] actualResult = StringUtils.split(phrase, ", ");
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testSplit_negative() {
        String[] actualResult = StringUtils.split(null, " ");
        assertArrayEquals(new String[0], actualResult);
    }

    @Test
    public void testParseUser_positive() {
        User actualUser = StringUtils.parseUser("Jasdhir,jasdhir123,27,email.com");
        assertAll(
                () -> assertEquals(27L, actualUser.getId()),
                () -> assertEquals("Jasdhir", actualUser.getName()),
                () -> assertEquals("jasdhir123@email.com", actualUser.getEmail())
        );
    }
}
