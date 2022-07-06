package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    private static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.
//		HashMap<OrgChart, OrgChart> reporteeManagerMap = new HashMap<>();
//		buildParentMap(topManager, reporteeManagerMap);
//
//		HashSet<OrgChart> reportee1Hierarchy = new HashSet<>();
//		OrgChart manager1 = reporteeManagerMap.get(reportOne);
//		while (manager1 != null) {
//			reportee1Hierarchy.add(manager1);
//			manager1 = reporteeManagerMap.get(manager1);
//		}
//
//		OrgChart manager2 = reporteeManagerMap.get(reportTwo);
//		while (manager2 != null) {
//			if (reportee1Hierarchy.contains(manager2)) {
//				return manager2;
//			}
//			manager2 = reporteeManagerMap.get(manager2);
//		}
//
//		return topManager; // Replace this line.
        ArrayList<OrgChart> reportOneHierarchy = new ArrayList<>();
        LowestCommonManager.buildParentMap(topManager, reportOne, reportOneHierarchy);

        ArrayList<OrgChart> reportTwoHierarchy = new ArrayList<>();
        LowestCommonManager.buildParentMap(topManager, reportTwo, reportTwoHierarchy);

        if (reportOneHierarchy.contains(reportTwo)) {
            return reportTwo;
        }

        if (reportTwoHierarchy.contains(reportOne)) {
            return reportOne;
        }

        int i = reportOneHierarchy.size();
        int j = reportTwoHierarchy.size();
        for (; i > 0 && j > 0; i--, j--) {
            if (!reportOneHierarchy.get(i - 1).equals(reportTwoHierarchy.get(j - 1))) {
                if (i < reportOneHierarchy.size()) {
                    return reportOneHierarchy.get(i);
                }
            }
        }
        if (i > 0 && i < reportOneHierarchy.size()) {
            return reportOneHierarchy.get(i);
        } else if (j > 0 && j < reportTwoHierarchy.size()) {
            return reportTwoHierarchy.get(j);
        }
        return topManager;
    }

//	public static void buildParentMap(OrgChart topManager, HashMap<OrgChart, OrgChart> map) {
//		if (!topManager.directReports.isEmpty()) {
//			for (OrgChart reportees : topManager.directReports) {
//				map.put(reportees, topManager);
//				buildParentMap(reportees, map);
//			}
//		}
//	}

    private static void buildParentMap(OrgChart topManager, OrgChart reportee, ArrayList<OrgChart> managersHierarchy) {
        if (topManager.directReports.contains(reportee)) {
            managersHierarchy.add(topManager);
            return;
        }
        for (OrgChart reporter : topManager.directReports) {
            LowestCommonManager.buildParentMap(reporter, reportee, managersHierarchy);
            if (!managersHierarchy.isEmpty()) {
                managersHierarchy.add(topManager);
                return;
            }
        }
    }

    public static void main(String[] args) {

//		{"directReports": ["B", "C", "D", "E", "F"], "id": "A", "name": "A"},
//	      {"directReports": ["G", "H", "I"], "id": "B", "name": "B"},
//	      {"directReports": ["J"], "id": "C", "name": "C"},
//	      {"directReports": ["K", "L"], "id": "D", "name": "D"},
//	      {"directReports": [], "id": "E", "name": "E"},
//	      {"directReports": ["M", "N"], "id": "F", "name": "F"},
//	      {"directReports": [], "id": "G", "name": "G"},
//	      {"directReports": ["O", "P", "Q", "R"], "id": "H", "name": "H"},
//	      {"directReports": [], "id": "I", "name": "I"},
//	      {"directReports": [], "id": "J", "name": "J"},
//	      {"directReports": ["S"], "id": "K", "name": "K"},
//	      {"directReports": [], "id": "L", "name": "L"},
//	      {"directReports": [], "id": "M", "name": "M"},
//	      {"directReports": [], "id": "N", "name": "N"},
//	      {"directReports": [], "id": "O", "name": "O"},
//	      {"directReports": ["T", "U"], "id": "P", "name": "P"},
//	      {"directReports": [], "id": "Q", "name": "Q"},
//	      {"directReports": ["V"], "id": "R", "name": "R"},
//	      {"directReports": [], "id": "S", "name": "S"},
//	      {"directReports": [], "id": "T", "name": "T"},
//	      {"directReports": [], "id": "U", "name": "U"},
//	      {"directReports": ["W", "X", "Y"], "id": "V", "name": "V"},
//	      {"directReports": [], "id": "W", "name": "W"},
//	      {"directReports": ["Z"], "id": "X", "name": "X"},
//	      {"directReports": [], "id": "Y", "name": "Y"},
//	      {"directReports": [], "id": "Z", "name": "Z"}

        OrgChart A = new OrgChart('A');
        OrgChart B = new OrgChart('B');
        OrgChart C = new OrgChart('C');
        OrgChart D = new OrgChart('D');
        OrgChart E = new OrgChart('E');
        OrgChart F = new OrgChart('F');
        OrgChart G = new OrgChart('G');
        OrgChart H = new OrgChart('H');
        OrgChart I = new OrgChart('I');
        OrgChart J = new OrgChart('J');
        OrgChart K = new OrgChart('K');
        OrgChart L = new OrgChart('L');
        OrgChart M = new OrgChart('M');
        OrgChart N = new OrgChart('N');
        OrgChart O = new OrgChart('O');
        OrgChart P = new OrgChart('P');
        OrgChart Q = new OrgChart('Q');
        OrgChart R = new OrgChart('R');
        OrgChart S = new OrgChart('S');
        OrgChart T = new OrgChart('T');
        OrgChart U = new OrgChart('U');
        OrgChart V = new OrgChart('V');
        OrgChart W = new OrgChart('W');
        OrgChart X = new OrgChart('X');
        OrgChart Y = new OrgChart('Y');
        OrgChart Z = new OrgChart('Z');

        A.directReports.add(B);
        A.directReports.add(C);
        A.directReports.add(D);
        A.directReports.add(E);
        A.directReports.add(F);

        B.directReports.add(G);
        B.directReports.add(H);
        B.directReports.add(I);

        C.directReports.add(J);

        D.directReports.add(K);
        D.directReports.add(L);

        F.directReports.add(M);
        F.directReports.add(N);

        H.directReports.add(O);
        H.directReports.add(P);
        H.directReports.add(Q);
        H.directReports.add(R);

        K.directReports.add(S);

        P.directReports.add(T);
        P.directReports.add(U);

        R.directReports.add(V);

        V.directReports.add(W);
        V.directReports.add(X);
        V.directReports.add(Y);

        X.directReports.add(Z);

        System.out.println(LowestCommonManager.getLowestCommonManager(A, T, H).name);

    }

    static class OrgChart {
        public char name;
        List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            directReports = new ArrayList<>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "" + name;
        }
    }
}
