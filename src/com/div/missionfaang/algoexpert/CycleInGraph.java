package com.div.missionfaang.algoexpert;

public class CycleInGraph {

    public boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        for (int i = 0; i < edges[i].length; i++) {
            boolean[] visitedVertices = new boolean[edges.length];
            if (findCycle(edges, visitedVertices, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean findCycle(int[][] edges, boolean[] visitedVertices, int index) {
        if (!visitedVertices[index]) {
            visitedVertices[index] = true;
            for (int i = 0; i < edges[index].length; i++) {
                boolean loopExists = findCycle(edges, visitedVertices, edges[index][i]);
                if (loopExists) {
                    return loopExists;
                }
            }
            return false;
        } else {
            return true;
        }
    }

}
