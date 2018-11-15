package com.me.stack.practice;

import java.util.LinkedList;

/**
 * PalindromeStack challenge solved using JDK LinkedList as a stack
 */
public class PalindromeStack {
    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    private static boolean checkForPalindrome(String string) {
        String cleanString = string.replaceAll("[^A-Za-z]","").toLowerCase();
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder reversed = new StringBuilder();
        for (char c : cleanString.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString().equals(cleanString);
    }
}
