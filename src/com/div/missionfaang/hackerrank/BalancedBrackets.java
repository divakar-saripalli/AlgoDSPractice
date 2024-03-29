package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Stack;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    private static String isBalanced(String s) {

        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('{') || c.equals('[')) {
                brackets.push(c);
            } else if (c.equals(')') || c.equals('}') || c.equals(']')) {
                if (brackets.isEmpty()) {
                    return "NO";
                }
                Character c1 = brackets.peek();
                if (Math.abs(c1 - c) > 2) {
                    return "NO";
                } else {
                    brackets.pop();
                }
            }
        }
        return brackets.isEmpty() ? "YES" : "NO";
    }

    static String isBalanced1(String s) {

        if (s.length() % 2 != 0) {
            return "NO";
        }

        int n = 0;
        while (s.length() != n) {
            n = s.length();
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            s = s.replace("()", "");
        }
        return s.length() != 0 ? "NO" : "YES";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(BalancedBrackets.isBalanced("[((([])([]){}){}){}([])[]((())"));
    }
}
