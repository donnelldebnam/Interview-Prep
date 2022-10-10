package test;

import static org.junit.Assert.*;

import junit.framework.*;
import org.junit.Test;

public class MainTest {

    @Test
    public void removeDuplicateLyrics_emptyString_throwsException() {}

    @Test
    public void mostOccuringNumber_emptyArr_throwsException() {
        int[] arr = new int[] {};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.mostOccuringNumber(arr);
        });

        String expectedMessage = "Array must at least be of length 1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void mostOccuringNumber_oneValue_returnsThatValue() throws Exception {
        int[] arr = new int[] {1};

        assertEquals(Main.mostOccuringNumber(arr), 1);
    }

    @Test
    public void mostOccuringNumber_entireList_returnsCorrectValue() throws Exception {
        int[] arr = new int[] {1,1,1,1,1,2,3,4,4,5,3,5,23,1,2,4,5,2,1,3,4,1,1,3,4,5,6,6,6,3};

        assertEquals(Main.mostOccuringNumber(arr), 1);
    }

    @Test
    public void mostOccuringNumber_multipleMostOccuringValues_returnsFirstMostOccuringValue() throws Exception {
        int[] arr = new int[] {1,1,1,2,2,2};

        assertEquals(Main.mostOccuringNumber(arr), 1);
    }

    @Test
    public void containsBalancedParentheses_emptyInput_returnTrue() {
        String str = "";

        assertTrue(Main.containsBalancedParentheses(str));
    }

    @Test
    public void containsBalancedParentheses_validParentheses_returnTrue() {
        assertTrue(Main.containsBalancedParentheses(MainConstants.VALID_PARENTHESES));
    }

    @Test
    public void containsBalancedParentheses_invalidParentheses_returnFalse() {
        assertFalse(Main.containsBalancedParentheses(MainConstants.INVALID_PARENTHESES));
    }

}
