package com.div.missionfaang.scaler.intermediate.recursion;

public class RecursionProblems {

    private static int sumOfDigits(int A) {
        if (A > 10) {
            A = RecursionProblems.sumOfDigits(A / 10) + (A % 10);
        }
        return A;
    }

    private static int sumOfDigitsToSingleDigit(int A) {
        while (A > 10) {
            A = RecursionProblems.sumOfDigits(A);
        }
        return (A == 10) ? 1 : 0;
    }

    private static void printReverseString(String s) {
        if (s.length() > 1) {
            RecursionProblems.printReverseString(s.substring(1));
        }
        System.out.print(s.charAt(0));
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

    private static int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }
        if (B == 1) {
            return C + (A % C);
        }
        int val = ((A % C) * RecursionProblems.pow(A, B / 2, C) % C) % C;
        long square = (long) val * val;
        if (A > 0 || B % 2 == 0) {
            return (int) (C + (square % C));
        } else {
            return (int) (C + (-1 * (((square % C) * (A % C)) % C)));
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String N = sc.nextLine();
//        System.out.println(RecursionProblems.sumOfDigitsToSingleDigit(83557));
        System.out.println(RecursionProblems.pow(-1, 1, 20));
    }
}
