package com.div.missionfaang.scaler.bitmanipulation;

import java.util.List;

public class BitManipulation1 {

    private static String addBinary(String A, String B) {
        String bigString = A.length() > B.length() ? A : B;
        String smallString = A.equals(bigString) ? B : A;
        StringBuilder result = new StringBuilder();
        char carry = '0';
        for (int i = smallString.length() - 1, j = bigString.length() - 1; i > -1; i--, j--) {
            if (smallString.charAt(i) != bigString.charAt(j)) {
                if (carry != '1') {
                    result.insert(0, "1");
                } else {
                    result.insert(0, "0");
                }
            } else {
                if (carry != '1') {
                    result.insert(0, "0");
                    if (smallString.charAt(i) == '1') {
                        carry = '1';
                    }
                } else {
                    result.insert(0, "1");
                    if (smallString.charAt(i) != '1') {
                        carry = '0';
                    }
                }
            }
        }

        for (int i = bigString.length() - smallString.length() - 1; i > -1; i--) {
            if (carry != '1') {
                result.insert(0, bigString.charAt(i));
            } else {
                if (bigString.charAt(i) != '1') {
                    result.insert(0, "1");
                    carry = '0';
                } else {
                    result.insert(0, "0");
                }
            }
        }
        if (carry == '1') {
            result.insert(0, "1");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(BitManipulation1.addBinary("1010110111001101101000", "1000011011000000111100110"));

    }

    public int uniqueNumberInArray(List<Integer> A) {
        int ans = 0;
        for (Integer integer : A) {
            ans = ans ^ integer;
        }
        return ans;
    }

    public int numberOf1Bits(int A) {
        int count = 0;
        while (A > 1) {
            if (A % 2 != 0) {
                count++;
            }
            A = A >> 1;
        }
        if (A == 1) {
            count++;
        }
        return count;
    }
}