package com.div.missionfaang.scaler.intermediate.recursion;

import java.util.ArrayList;

public class RecursionProblems {

    /**
     * Given a number A, we need to find the sum of its digits using recursion.
     * <p>
     * Example Input 1: A = 46
     * Input 2: A = 11
     * <p>
     * <p>
     * Example Output 1: 10
     * Output 2: 2
     *
     * @param A
     * @return
     */
    private static int sumOfDigits(int A) {
        if (A > 10) {
            A = RecursionProblems.sumOfDigits(A / 10) + (A % 10);
        }
        return A;
    }

    /**
     * Given a number A, check if it is a magic number or not.
     * <p>
     * A number is said to be a magic number if the sum of its digits is calculated till a single digit
     * recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1,
     * then the number is a magic number.
     * <p>
     * Example Input 1: A = 83557
     * Input 2: A = 1291
     * <p>
     * <p>
     * Example Output 1: 1
     * Output 2: 0
     *
     * @param A
     * @return
     */
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

    /**
     * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
     * and each occurrence of 1 with 10.
     * <p>
     * Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
     *
     * @param A
     * @return
     */
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

    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * <p>
     * Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
     * <p>
     * A gray code sequence must begin with 0.
     * <p>
     * for A = 2 the gray code sequence is:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * So, return [0,1,3,2].
     * <p>
     * for A = 1 the gray code sequence is:
     * 00 - 0
     * 01 - 1
     * So, return [0, 1].
     *
     * @param a
     * @return
     */
    private static ArrayList<Integer> grayCode(int a) {
        if (a == 1) {
            ArrayList<Integer> result = new ArrayList<>(2);
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> result = RecursionProblems.grayCode(a - 1);
        int end = result.size();
        for (int i = end - 1; i > -1; i--) {
            result.add(result.get(i) + (1 << (a - 1)));
        }
        return result;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String N = sc.nextLine();
//        System.out.println(RecursionProblems.sumOfDigitsToSingleDigit(83557));
//        System.out.println(RecursionProblems.pow(-1, 1, 20));
        System.out.println(RecursionProblems.grayCode(4));
    }
}
