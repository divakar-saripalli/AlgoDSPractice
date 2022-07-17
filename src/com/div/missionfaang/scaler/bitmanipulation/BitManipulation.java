package com.div.missionfaang.scaler.bitmanipulation;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.List;

public class BitManipulation {

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

    private static long reverse(long a) {
        int bit;
        StringBuilder reverseBinary = new StringBuilder();
        while (a >= 2) {
            bit = (int) (a % 2);
            a /= 2;
            reverseBinary.append(bit);
        }
        reverseBinary.append(a);
        int length = reverseBinary.length();
        if (length < 32) {
            reverseBinary.append("0".repeat(Math.max(0, 32 - length)));
        }
        a = 0;
        for (int i = reverseBinary.length() - 1, j = 0; i > -1; i--, j++) {
            if (reverseBinary.charAt(i) == '1') {
                a += Math.pow(2, j);
            }
        }
        return a;
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
//        long sum = 0;
//        for (Integer integer : B) {
//            sum += integer;
//        }
//        return sum - B;
        return 0L;
    }

    private static ArrayList<Integer> singleNumber3(ArrayList<Integer> A) {
        int xor = 0;
        for (Integer integer : A) {
            xor ^= integer;
        }
        int mask = (xor & xor - 1) ^ xor;
        int unique1 = 0;
        int unique2 = 0;

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

    public static void main(String[] args) {
//        System.out.println(BitManipulation.helpFromSam(3));
//        System.out.println(BitManipulation.unsetXBits(53L, 5));
        int[] arr1 = new int[]{186, 256, 102, 377, 186, 377};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr1);
        System.out.println(BitManipulation.singleNumber3(array));
    }
}