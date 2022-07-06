package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        List<Map<String, Integer>> blocksData = new ArrayList<>();

        if (blocks.size() > 0) {

            Map<String, Integer> blockData = new HashMap<>();
            for (int i = 0; i < reqs.length; i++) {
                if (blocks.get(0).get(reqs[i]) != null && blocks.get(0).get(reqs[i])) {
                    blockData.put(reqs[i], 0);
                }
            }

            blocksData.add(blockData);

            for (int i = 1; i < blocks.size(); i++) {
                blockData = new HashMap<>();
                for (int j = 0; j < reqs.length; j++) {
                    if (blocks.get(i).get(reqs[j]) != null && blocks.get(i).get(reqs[j])) {
                        blockData.put(reqs[j], 0);
                    } else if (blocksData.get(i - 1).get(reqs[j]) != null) {
                        blockData.put(reqs[j], blocksData.get(i - 1).get(reqs[j]).intValue() + 1);
                    }
                }
                blocksData.add(blockData);
            }

            for (int i = blocks.size() - 2; i > -1; i--) {
                for (int j = 0; j < reqs.length; j++) {
                    if (blocksData.get(i + 1).get(reqs[j]) != null
                            && (blocksData.get(i).get(reqs[j]) == null || blocksData.get(i).get(reqs[j])
                            .intValue() > blocksData.get(i + 1).get(reqs[j]).intValue() + 1)) {
                        blocksData.get(i).put(reqs[j], blocksData.get(i + 1).get(reqs[j]).intValue() + 1);
                    }
                }
            }

            int minDistance = Integer.MAX_VALUE;
            int index = 0;
            int minDistanceIndex = -1;
            for (Map<String, Integer> map : blocksData) {
                int maxDistance = Integer.MIN_VALUE;
                for (String key : map.keySet()) {
                    maxDistance = Math.max(map.get(key).intValue(), maxDistance);
                }
                if (maxDistance < minDistance) {
                    minDistance = maxDistance;
                    minDistanceIndex = index;
                }
                index++;
            }
            return minDistanceIndex;
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        Map<String, Boolean> block = new HashMap<>();
        block.put("gym", false);
        block.put("school", true);
        block.put("store", false);
        blocks.add(block);

        block = new HashMap<>();
        block.put("gym", true);
        block.put("school", false);
        block.put("store", false);
        blocks.add(block);

        block = new HashMap<>();
        block.put("gym", true);
        block.put("school", true);
        block.put("store", false);
        blocks.add(block);

        block = new HashMap<>();
        block.put("gym", false);
        block.put("school", true);
        block.put("store", false);
        blocks.add(block);

        block = new HashMap<>();
        block.put("gym", false);
        block.put("school", true);
        block.put("store", true);
        blocks.add(block);

        String[] reqs = new String[]{"gym", "school", "store"};

        apartmentHunting(blocks, reqs);
    }
}
