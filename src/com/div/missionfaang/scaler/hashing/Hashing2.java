package com.div.missionfaang.scaler.hashing;

import com.div.missionfaang.scaler.Scaler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Hashing2 {

    public ArrayList<Integer> subarrayWithGivenSum(ArrayList<Integer> A, int B) {
        int sum = 0;
        int startIndex = 0;
        boolean found = false;
        for (Integer integer : A) {
            sum += integer;
            if (sum > B) {
                while (sum > B) {
                    sum -= A.get(startIndex);
                    startIndex++;
                }
            }
            if (sum == B) {
                found = true;
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (found) {
            sum = 0;
            for (int i = startIndex; sum < B; i++) {
                result.add(A.get(i));
                sum += A.get(i);
            }
        } else {
            result.add(-1);
        }
        return result;
    }

    public int diffK_II(List<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        if (A.get(0) > B) {
            set.add(A.get(0) - B);
        } else {
            set.add(A.get(0) + B);
        }
        for (int i = 1; i < A.size(); i++) {
            if (set.contains(A.get(i))) {
                return 1;
            } else {
                if (A.get(i) >= B) {
                    set.add(A.get(i) - B);
                } else {
                    set.add(A.get(i) + B);
                }
            }
        }
        return 0;
    }

    private static ArrayList<Integer> twoSum(List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() < 2) {
            return result;
        }
        if (A.size() == 2 && (A.get(0) + A.get(1) == B)) {
            result.add(0);
            result.add(1);
            return result;
        }

        HashSet<Integer> set = new HashSet<>();
        int index2 = 1;
        for (Integer integer : A) {
            if (set.contains(integer)) {
                int index = 1;
                for (Integer integer1 : A) {
                    if (integer1 == (B - integer)) {
                        result.add(index);
                        break;
                    }
                    index++;
                }
                result.add(index2);
                break;
            } else {
                set.add(B - integer);
                index2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr);
        System.out.println(Hashing2.twoSum(array, -3));
    }
}
