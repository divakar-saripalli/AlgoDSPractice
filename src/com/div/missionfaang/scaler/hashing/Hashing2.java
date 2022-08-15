package com.div.missionfaang.scaler.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Hashing2 {
    public static void main(String[] args) {

    }

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
}
