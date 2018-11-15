package com.me.stack.practice;

import java.util.LinkedList;

/**
 * Check if brackets are balanced in string.
 * Each open bracket should correspond to close bracket of the same type.
 * Types of brackets are : '()', '[]', '{}'.
 * Challenge solved using JDK LinkedList as a stack.
 */
public class Brackets {
    public static void main(String[] args){
        //should return true
        System.out.println(areBracketsBalanced("[({[a]})]"));
        //should return false
        System.out.println(areBracketsBalanced("[(([{[a]})]"));
        //should return true
        System.out.println(areBracketsBalanced("[a[b[c{d()()e{f}}[]g]]h]{^}"));
        //should return false
        System.out.println(areBracketsBalanced("]["));
        //should return false
        System.out.println(areBracketsBalanced("["));
        //should return true
        System.out.println(areBracketsBalanced("abc"));
    }

    private static boolean areBracketsBalanced(String input){
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty()) {
                        char opened = stack.pop();
                        if (opened == '(' && c != ')' ||
                                opened == '[' && c != ']' ||
                                opened == '{' && c != '}')
                            return false;
                    } else return false;
            }
        }
        return stack.isEmpty();
    }
}
