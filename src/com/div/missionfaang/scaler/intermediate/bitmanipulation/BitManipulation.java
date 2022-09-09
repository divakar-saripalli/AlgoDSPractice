package com.div.missionfaang.scaler.intermediate.bitmanipulation;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class BitManipulation {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * Example:
     * a = "100"
     * b = "11"
     * Return a + b = "111".
     *
     * @param A binary representation of an integer
     * @param B binary representation of an integer
     * @return String binary representation of sum.
     */
    private static String addBinary(String A, String B) {
        return BitManipulation.addBinaryStrings(A, B);
    }

    public static String addBinaryStrings(String A, String B) {
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

    /**
     * Reverse the bits of an 32-bit unsigned integer A.
     *
     * @param a integer to be reversed (bits)
     * @return integer
     */
    private static long reverse(long a) {
        long result = 0;
        boolean add1 = ((a & 1) == 1);
        for (int i = 0, j = 31; i < 32; i++, j--) {
            if ((a & 1) != 0) {
                if (i == 0) {
                    // Because the greatest positive long is (2^31) - 1
                    result += (1L << j) - 1;
                } else {
                    result += 1L << j;
                }
            }
            a = a >> 1;
        }
        // returning result + 1 if the original number is odd because it was reduced by 1 
        // while calculating the reverse bit above.
        return (add1) ? result + 1 : result;
    }

    private static String interestingArray(ArrayList<Integer> A) {
        int count = 0;
        for (Integer integer : A) {
            if (integer % 2 != 0) {
                count++;
            }
        }
        return count % 2 == 0 ? "YES" : "NO";
    }

    public int uniqueNumberInArray(List<Integer> A) {
        int ans = 0;
        for (Integer integer : A) {
            ans = ans ^ integer;
        }
        return ans;
    }

    /**
     * Write a function that takes an integer and returns the number of 1 bits it has.
     * <p>
     * Any number N ANDing with N-1 will make the last set-bit of N to 0.
     * So, ANDing a number with number 1 less than it until it becomes 0 will give us
     * the count of set bits.
     *
     * @param A
     * @return
     */
    public static int numberOf1Bits(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A = A & (A - 1);
        }
        return count;
    }

    private static int helpFromSam(int A) {
        int count = 0;
        while (A != 0) {
            if ((A & 1) > 0) {
                count++;
            }
            A >>= 1;
        }
        return count;
    }

    private static int findGoodDays(int A) {
        int count = 0;
        while (A > 0) {
            A = A & (A - 1);
            count++;
        }
        return count;
    }

    private static Long subarrayWithBitwiseOr1(int A, ArrayList<Integer> B) {
        int sum = 0;
        for (int i = 0; i < A; i++) {
            if (B.get(i) == 1) {
                sum += A - i;
            } else {
                for (int j = i; j < A; j++) {
                    if (B.get(j) == 1) {
                        sum += A - j;
                        break;
                    }
                }
            }
        }
        return (long) sum;
    }

    /**
     * Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
     * Find the two integers that appear only once.
     * <p>
     * Note: Return the two numbers in ascending order.
     *
     * @param A
     * @return ArrayList
     */
    private static ArrayList<Integer> singleNumber3(ArrayList<Integer> A) {
        int xor = 0;
        for (Integer integer : A) {
            xor ^= integer;
        }

        // The XOR calculated by now is XOR of two unique elements in the array.
        // That would mean that the last set-bit in the XOR is set for one
        // of the two unique numbers and not for the other unique number.
        // To find the unique numbers, we generate a mask which has the only
        // one bit set. The place of the set bit is equal to the last set-bit
        // of the above XOR result. To generate the mask, the idea followed is
        // ANDing the XOR result with (XOR result - 1). This would toggle all the
        // bits to the right of last set-bit. Now XORing the resultant with the
        // original XOR result would set only the last set bit and remaining to 0.
        int mask = (xor & xor - 1) ^ xor;
        int unique1 = 0;
        int unique2 = 0;

        // Once the mask is found, AND the mask with all the elements of the array again.
        // The elements with the bit set would have a value greater than or equal to 1.
        // XORing all those elements would result in one unique element.
        // Similarly, XORing all the elements whose AND with mask is 0 will result in
        // another unique number.
        for (Integer integer : A) {
            if ((integer & mask) >= 1) {
                unique1 ^= integer;
            } else {
                unique2 ^= integer;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Math.min(unique1, unique2));
        result.add(Math.max(unique2, unique1));
        return result;
    }

    private static Long unsetXBits(Long A, int B) {
        return A & ((long) Math.pow(2, 31) - 1 << (B));
    }

    private static int compressBits(ArrayList<Integer> A) {
        int result = 0;
        for (Integer integer : A) {
            result ^= integer;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(BitManipulation.helpFromSam(3));
//        System.out.println(BitManipulation.unsetXBits(53L, 5));
        int[] arr1 = new int[]{186, 256, 102, 377, 186, 377};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(BitManipulation.singleNumber3(array));
    }
}