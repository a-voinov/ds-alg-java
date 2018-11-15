package com.me.queue.practice;

import java.util.LinkedList;

/**
 * PalindromeStack challenge solved using JDK Linked List as stack and queue
 */
public class PalindromeQueue {
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
        string = string.replaceAll("[^A-Za-z]", "").toLowerCase();
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : string.toCharArray()) {
            stack.push(c);
            queue.addLast(c);
        }

        while (!stack.isEmpty())
            if (!stack.pop().equals(queue.removeFirst()))
                return false;

        return true;
    }
}
