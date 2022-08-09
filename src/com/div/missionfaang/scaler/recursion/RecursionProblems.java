package com.div.missionfaang.scaler.recursion;

import java.util.Scanner;

public class RecursionProblems {

    private static int sumOfDigits(int A) {
        if (A < 10) {
            return A;
        }
        return RecursionProblems.sumOfDigits(A / 10) + (A % 10);
    }

    private static void printReverseString(String s) {
        if (s.length() > 1) {
            RecursionProblems.printReverseString(s.substring(1));
        }
        System.out.print(s.charAt(0));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        RecursionProblems.printReverseString(N);
    }

    private int checkPalindrome(String A) {
        if (A.length() == 1) {
            return 1;
        }
        if (A.length() == 2) {
            return (A.charAt(0) == A.charAt(1)) ? 1 : 0;
        }

        if (A.charAt(0) != A.charAt(A.length() - 1)) {
            return 0;
        }

        return checkPalindrome(A.substring(1, A.length() - 1));
    }

    private int findAthFibonacci(int A) {
        if (A < 1) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }

    private int findFactorial(int A) {
        if (A < 2) {
            return 1;
        }
        return A * findFactorial(A - 1);
    }
}
