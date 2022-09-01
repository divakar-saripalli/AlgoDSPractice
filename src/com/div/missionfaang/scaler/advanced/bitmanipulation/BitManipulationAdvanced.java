package com.div.missionfaang.scaler.advanced.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class BitManipulationAdvanced {
    private static int singleNumber(List<Integer> A) {
        int number = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            number ^= A.get(i);
        }
        return number;
    }

    private static int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A = A & (A - 1);
        }
        return count;
    }

    private static String addBinary(String A, String B) {
        if (A.length() > B.length()) {
            B = "0".repeat(A.length() - B.length()) + B;
        } else if (B.length() > A.length()) {
            A = "0".repeat(B.length() - A.length()) + A;
        }

        StringBuilder result = new StringBuilder();
        boolean carry = false;
        for (int i = A.length() - 1; i > -1; i--) {
            if (A.charAt(i) == B.charAt(i)) {
                if (carry) {
                    result.append('1');
                } else {
                    result.append('0');
                }
                carry = (A.charAt(i) == '1');
            } else {
                if (carry) {
                    result.append('0');
                } else {
                    result.append('1');
                }
            }
        }
        if (carry) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    private static int singleNumberII(List<Integer> A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (Integer integer : A) {
                if ((integer & (1 << i)) > 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans += 1 << i;
            }
        }
        return ans;
    }

    private static String interestingArray(ArrayList<Integer> A) {
        int count = A.size();
        for (Integer integer : A) {
            if ((integer & 1) == 0) {
                count--;
            }
        }
        return ((count & 1) == 0) ? "Yes" : "No";
    }
}
