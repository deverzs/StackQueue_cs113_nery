package edu.miracosta.cs113;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * PalindromeTester : a test class for isPalindrome, a method intended to utilize stacks to evaluate if a given
 * string is a palindrome.
 *
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards as it does
 * forwards. Such sequences include "madam," "top spot," or "no lemon, no melon".
 */
public class PalindromeTester {

    /** True test cases which include spaces and symbols */
    private static final String[] SIMPLE_TRUE = { "", " ", "A", "7", "%", "  ", "BB", "33", "**" };
    /** False test cases which include spaces and symbols */
    private static final String[] SIMPLE_FALSE = { "AC", "71", "@+" };

    /** True test cases which include spaces */
    private static final String[] WHITE_SPACE_TRUE = { " x ", " t   t  ", " 5 5", " #      # " };
    /** False test cases which include spaces */
    private static final String[] WHITE_SPACE_FALSE = { "m   n  ", "   8  7 ", "  ^      &  "};

    /** Case-sensitive palindromes */
    private static final String[] CASE_SENSITIVE_TRUE = { "ABba", "roTOR", "rAceCaR" };

    /** Complex palindromes which include spaces, symbols, and varied capitalization */
    private static final String[] COMPLEX_TRUE = { "fOO race CAR oof", "AbBa ZaBba", "1 3 3 7  331",
                                                "N0 LEm0n, n0 Mel0n",
                                                "sT RJKLEeE R#@ $A$ @# REeEL K  JRT s" };

    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param s a string comprised of any character
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     * @author Zsuzsanna Dianovcis
     */
    private boolean isPalindrome(String s) {
        // checking if null
        if (s == null) {
            throw new IllegalArgumentException() ;
        }
        // check if single string
        if (s.length() == 0 || s.length() == 1) {
               return true ;
        }
        // if only 2 characters, check if they are the same
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return true ;
            }
            else {
                return false ;
            }
        }
        boolean result = true ;
        Character newChar ;
        ArrayListStack<Character> original  ;
        ArrayListStack<Character> compareTo = new ArrayListStack<Character>() ;
        original = stringToStack(s) ;
        int newString = cleanString(s).length() ;
        int half = newString /2 ;
        for (int i = 0 ; i < half ; i++){
            newChar = original.pop() ;
            compareTo.push(newChar) ;
        }
        // check if string is even or odd
        if (newString % 2 == 1) {
            original.pop() ; // pop off an extra, if odd
        }
        Character comp1 ;
        Character comp2 ;
        // now the stacks should be the same
        for (int i = 0 ; i < half; i++) {
            comp1 = original.pop() ;
            comp2 = compareTo.pop() ;
            if (!(comp1==comp2)) {
                result = false ;
            }
        }
        return result ;

    } // End of method isPalindrome


    // Palindrome Helper Methods

    /**
     * This is a helper method to isPalindrome(). It returns a stack of the strings
     * @param s An incoming string to be parsed into a stack
     * @return the stack that the string is parsed into
     * @author Zsuzsanna Dianovics
     */
    public static ArrayListStack stringToStack(String s) {
        ArrayListStack<Character> stack = new ArrayListStack<>() ;
        Character newChar ;
        s = cleanString(s);
        int stringSize = s.length() ;
        for (int i = 1; i < (stringSize); i++) {
            newChar = s.charAt(0) ;
            stack.push(newChar) ;
            s =s.substring(1) ;
        }
        newChar = s.charAt(0) ;
        stack.push(newChar);
        return stack ;
    }

    /**
     * This is a helper method to the stringToStack() which cleans a string of whitespace and converted
     * to lower case
     * @param s  The string to be cleaned
     * @return  The cleaned string
     * @author Zsuzsanna Dianovics
     */
    public static String cleanString(String s) {
        s = s.toLowerCase() ;
        s = s.replaceAll("\\s", "") ;
        return s ;

    }



    // region isPalindrome tests =======================================================================================

    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        for (int i = 0; i < SIMPLE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(SIMPLE_TRUE[i]));
        }
    }

    @Test
    public void testSimpleFalseCases() {
        for (int i = 0; i < SIMPLE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(SIMPLE_FALSE[i]));
        }
    }

    @Test
    public void testWhitespaceCases() {
        for (int i = 0; i < WHITE_SPACE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(WHITE_SPACE_TRUE[i]));
        }

        for (int i = 0; i < WHITE_SPACE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(WHITE_SPACE_FALSE[i]));
        }
    }

    @Test
    public void testCaseSensitivityCases() {
        for (int i = 0; i < CASE_SENSITIVE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(CASE_SENSITIVE_TRUE[i]));
        }
    }

    @Test
    public void testComplexCases() {
        for (int i = 0; i < COMPLEX_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(COMPLEX_TRUE[i]));
        }
    }

    // endregion isPalindrome tests ====================================================================================

} // End of class PalindromeTester