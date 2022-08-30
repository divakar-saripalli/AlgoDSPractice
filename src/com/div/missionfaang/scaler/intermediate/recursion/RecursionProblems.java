package com.div.missionfaang.scaler.intermediate.recursion;

import java.util.ArrayList;

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
        if (A < 0) {
            A = (A + C) % C;
        }
        long hp = RecursionProblems.pow(A, B / 2, C);
        long ia = ((hp * hp) % C);
        if (B % 2 == 0) {
            return (int) ia;
        } else {
            return (int) ((ia * A) % C);
        }
    }

    private static int kthSymbol(int A, int B) {
        return RecursionProblems.kthSymbol(A).toString().charAt(B - 1) == '0' ? 0 : 1;
    }

    private static StringBuffer kthSymbol(int A) {
        if (A == 1) {
            return new StringBuffer("0");
        }
        StringBuffer buf = RecursionProblems.kthSymbol(A - 1);
        for (int i = 0; i < buf.length(); i++) {
            if (buf.charAt(i) == '0') {
                buf.append('1');
            } else {
                buf.append('0');
            }
            i++;
        }
        return buf;
    }

    private static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, a); i++) {
            result.add(i);
        }
        result.add(0);
        result.add(1);
        return RecursionProblems.grayCode(a, result, 1, true);
    }

    private static ArrayList<Integer> grayCode(int a, ArrayList<Integer> result, int lastValue, boolean anding) {
        if (lastValue == 0) {
            return result;
        }
        if (anding) {
            lastValue = lastValue << 1;
            lastValue = lastValue + 1;
        } else {
            lastValue = lastValue & (lastValue - 1);
        }
        if (lastValue > 1) {
            result.add(lastValue);
        }
        if (lastValue == Math.pow(2, a) - 1) {
            anding = false;
        }
        return RecursionProblems.grayCode(a, result, lastValue, anding);
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String N = sc.nextLine();
//        System.out.println(RecursionProblems.sumOfDigitsToSingleDigit(83557));
//        System.out.println(RecursionProblems.pow(-1, 1, 20));
        System.out.println(RecursionProblems.grayCode(3));
    }
}
