package edu.miracosta.cs113;

import java.util.Stack;

public class PalindromeDriver {

    public static void main (String args[]) {
        System.out.println("Hello");
        ArrayListStack stack = new ArrayListStack() ;
        String test = "hot" ;
        ArrayListStack<String> tester = new ArrayListStack<String>() ;
/*        tester.push("A") ;
        tester.push("B") ;
        tester.push("C") ;

        System.out.println("Popping: " + tester.pop());
        System.out.println("Popping: " + tester.pop());
        System.out.println("Popping: " + tester.pop());

*/

        System.out.println("Is " + test + " a palindrome? " + isPalindrome(test)) ;
    }

    private static boolean isPalindrome(String s) {

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

        if (newString % 2 == 1) {
            original.pop() ;
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
    }

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

    public static String cleanString(String s) {

        // Remove white space, to lower case
        s = s.toLowerCase() ;
        s = s.replaceAll("\\s", "") ;
        System.out.println("Cleaned up String: " + s);


        return s ;


    }
}
