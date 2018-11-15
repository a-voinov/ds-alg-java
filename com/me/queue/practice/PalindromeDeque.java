package com.me.queue.practice;

import java.util.ArrayDeque;

/**
 * PalindromeStack challenge solved using JDK ArrayDeque as a deque
 */
public class PalindromeDeque {
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
        // should return true
        System.out.println(checkForPalindrome("A nut for a jar of tuna."));
        // should return true
        System.out.println(checkForPalindrome("Al lets Della call Ed “Stella.”"));
        // should return true
        System.out.println(checkForPalindrome("Amore, Roma."));
        // should return true
        System.out.println(checkForPalindrome("Are we not pure? “No, sir!” Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man—a prisoner up to new era."));
        // should return true
        System.out.println(checkForPalindrome("Borrow or rob?"));
        // should return true
        System.out.println(checkForPalindrome("Taco cat"));
    }

    private static boolean checkForPalindrome(String string) {
        string = string.replaceAll("[^A-Za-z]", "").toLowerCase();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : string.toCharArray()) {
            deque.add(c);
        }
        while (!deque.isEmpty()){
            Character last = deque.pollLast();
            Character first = deque.pollFirst();
            if (first == null && last != null) return true;
            if (last != first) return false;
        }
        return true;
    }
}
