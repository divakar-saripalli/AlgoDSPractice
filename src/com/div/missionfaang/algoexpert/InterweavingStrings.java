package com.div.missionfaang.algoexpert;

public class InterweavingStrings {

	public static boolean interweavingStrings(String one, String two, String three) {
		// Write your code here.
		return checkIfInterveavingStrings(one, two, three, 0, 0);
	}

	private static boolean checkIfInterveavingStrings(String one, String two, String three, int i, int j) {
		// TODO Auto-generated method stub
		int k = i + j;

		if (k == three.length()) {
			return true;
		}

		if (i < one.length() && three.charAt(k) == one.charAt(i)) {
			if (checkIfInterveavingStrings(one, two, three, i + 1, j)) {
				return true;
			}
		}
		if (j < two.length() && three.charAt(k) == two.charAt(j)) {
			return checkIfInterveavingStrings(one, two, three, i, j + 1);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(interweavingStrings("aabcc", "dbbca", "aadbbcbcac"));
	}
}
