package com.div.missionfaang.scaler.advanced.bitmanipulation;

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
        while (A > 1) {
            if ((A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count + A;
    }
}
