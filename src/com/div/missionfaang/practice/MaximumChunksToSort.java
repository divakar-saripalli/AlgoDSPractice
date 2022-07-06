package com.div.missionfaang.practice;

import java.util.Stack;

public class MaximumChunksToSort {

    public MaximumChunksToSort() {
    }

    private static int countChunks(int[] array) {
        if (array != null && 0 != array.length) {
            Stack<int[]> chunks = new Stack<>();

            for (int i : array) {
                int min = i;
                int max = i;

                while (!chunks.isEmpty()) {
                    int[] top = chunks.peek();

                    if (i >= top[1]) {
                        break;
                    }

                    min = Math.min(top[0], min);
                    max = Math.max(max, top[1]);
                    chunks.pop();
                }
                chunks.push(new int[]{min, max});
            }
            return chunks.size();
        } else {
            return 0;
        }
    }

    public static void main(String[] var0) {
        // Below line is just to avoid warnings.

        MaximumChunksToSort.countChunks(new int[3]);
    }

}
