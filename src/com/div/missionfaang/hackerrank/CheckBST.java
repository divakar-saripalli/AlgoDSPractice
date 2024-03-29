package com.div.missionfaang.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CheckBST {

    boolean checkBST(Node root) {
        List<Integer> list = new ArrayList<>();
        convertTreeToList(root, list);
        if (list.size() < 2) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void convertTreeToList(Node root, List<Integer> list) {
        if (root != null) {

            if (root.left != null) {
                convertTreeToList(root.left, list);
            }

            list.add(root.data);

            if (root.right != null) {
                convertTreeToList(root.right, list);
            }
        }
    }
}
