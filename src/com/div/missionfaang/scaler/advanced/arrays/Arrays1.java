package com.div.missionfaang.scaler.advanced.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class Arrays1 {

    private static ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> beggarsPots = new ArrayList<>(A);
        for (int i = 0; i < A; i++) {
            beggarsPots.add(0);
        }
        for (ArrayList<Integer> pots : B) {
            beggarsPots.set(pots.get(0) - 1, beggarsPots.get(pots.get(0) - 1) + pots.get(2));
            if (pots.get(1) < A) {
                beggarsPots.set(pots.get(1), beggarsPots.get(pots.get(1)) + (pots.get(2) * -1));
            }
        }

        for (int i = 1; i < A; i++) {
            beggarsPots.set(i, beggarsPots.get(i) + beggarsPots.get(i - 1));
        }
        return beggarsPots;
    }

    public int kadaneAlgorithm(List<Integer> A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (Integer integer : A) {
            sum += integer;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    private static int trap(List<Integer> A) {

        if (A.size() < 3) {
            return 0;
        }

        List<Integer> leftMaxArray = new ArrayList<>();
        List<Integer> rightMaxArray = new ArrayList<>();
        int sum = 0;

        leftMaxArray.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            leftMaxArray.add(Math.max(leftMaxArray.get(i - 1), A.get(i)));
        }

        rightMaxArray.add(A.get(A.size() - 1));
        for (int i = A.size() - 2; i > -1; i--) {
            rightMaxArray.add(0, Math.max(rightMaxArray.get(0), A.get(i)));
        }

        for (int i = 0; i < A.size(); i++) {
            sum += Math.min(leftMaxArray.get(i), rightMaxArray.get(i)) - A.get(i);
        }
        return sum;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        boolean carry = false;
        int i = A.size();
        do {
            i--;
            if (i < 0) {
                if (carry) {
                    A.add(0, 1);
                }
                break;
            }
            if (A.get(i) == 9) {
                A.set(i, 0);
                carry = true;
            } else {
                A.set(i, A.get(i) + 1);
                carry = false;
            }
        } while (carry);
        int leadingZeros = 0;
        for (Integer integer : A) {
            if (integer != 0) {
                break;
            }
            leadingZeros++;
        }
        if (i > 0) {
            A.subList(0, leadingZeros).clear();
        }
        return A;
    }

    private static ArrayList<Integer> maxNonNegativeSubArray(ArrayList<Integer> A) {
//        int maxCount = 0;
//        int count = 0;
//        int start = -1;
//        int end = -1;
//        int maxStart = -1;
//        int maxEnd = -1;
//        for (int i = 0; i < A.size(); i++) {
//            if (A.get(i) > -1) {
//                count++;
//                if (start == -1) {
//                    start = i;
//                }
//                end = i;
//            } else if (maxCount < count) {
//                maxCount = count;
//                maxStart = start;
//                maxEnd = end;
//                start = -1;
//                count = 0;
//            } else if ((maxCount == count) &&
//                    ((maxEnd - maxStart < end - start))) {
//                maxStart = start;
//                maxEnd = end;
//                start = -1;
//                count = 0;
//            }
//        }
//        if (start > 0 && maxCount <= count) {
//
//            maxStart = start;
//            maxEnd = end;
//        }
//        if (maxStart >= 0) {
//            return new ArrayList<>(A.subList(maxStart, maxEnd + 1));
//        }
//        return new ArrayList<>();
        ArrayList<Long> prefixSumArray = new ArrayList<>(A.size());
        prefixSumArray.add(Long.valueOf(A.get(0)));
        for (int i = 1; i < A.size(); i++) {
            prefixSumArray.add(prefixSumArray.get(i - 1) + A.get(i));
        }

        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        int start = 0;
        int end = 0;
        int maxStart = -1;
        int maxEnd = -1;
        if (prefixSumArray.get(0) > 0) {
            sum = prefixSumArray.get(0);
        }
        for (int i = 1; i < prefixSumArray.size(); i++) {
            if (A.get(i) < A.get(i - 1)) {
                // This means we encountered a negative number.
                if (maxSum < sum) {
                    maxStart = start;
                    maxEnd = end;
                    maxSum = sum;
                }
                sum = 0;
                start = i + 1;
                end = i + 1;
            } else {
                sum += prefixSumArray.get(i);
                end = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = maxStart; i <= maxEnd && i > -1; i++) {
            result.add(A.get(i));
        }
        return result;
    }

    /**
     * You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
     * In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
     * By flipping, we mean changing character 0 to 1 and vice-versa.
     * <p>
     * Your aim is to perform AT MOST one operation such that in the final string number of 1s is maximized.
     * <p>
     * If you don't want to perform the operation, return an empty array.
     * Else, return an array consisting of two elements denoting L and R.
     * If there are multiple solutions, return lexicographically the smallest pair of L and R.
     * <p>
     * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
     * <p>
     * Approach:
     * <p>
     * We are supposed to find the subarray which has 0's outnumbering the 1s
     * and find the maximum subarray among all such sub-arrays.
     *
     * @param A
     * @return
     */
    private static ArrayList<Integer> flip(String A) {
        int maxLeft = -1;
        int maxRight = -1;
        int left = 0;
        int right = -1;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                sum += 1;
            } else {
                sum += -1;
            }
            if (max < sum) {
                max = sum;
                right = i;
                maxLeft = left;
                maxRight = right;
            }
            if (sum < 0) {
                sum = 0;
                left = i + 1;
            }
        }
        if (left < right) {
            maxLeft = left;
        }
        if (maxLeft > -1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(maxLeft + 1);
            res.add(maxRight + 1);
            return res;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{756898537, -1973594324, -2038664370, -184803526, 1424268980};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(Arrays1.flip("1100100"));
    }
}
