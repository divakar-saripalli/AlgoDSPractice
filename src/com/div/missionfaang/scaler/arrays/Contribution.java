package com.div.missionfaang.scaler.arrays;

import java.util.ArrayList;

public class Contribution {
    private static Long subarraySum(ArrayList<Integer> A) {
        long sum = 0L;
        for (int i = 0; i < A.size(); i++) {
            sum += (long) (i + 1) * (A.size() - i) * A.get(i);
        }
        return sum;
    }
}
