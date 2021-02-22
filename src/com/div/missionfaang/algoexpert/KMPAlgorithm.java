package com.div.missionfaang.algoexpert;

public class KMPAlgorithm {
	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		// Write your code here.
		int[] prefixTable = buildPrefixTable(substring);

		int i = 0;
		int j = 0;

		while (i < string.length() && j < substring.length()) {
			if (string.charAt(i) == substring.charAt(j)) {
				j++;
				i++;
			} else {
				if (j > 0) {
					j = prefixTable[j - 1];
				} else {
					i++;
				}
			}
		}
		return j >= substring.length();
	}

	public static int[] buildPrefixTable(String pattern) {
		int i = 0;
		int j = 1;
		int[] patternArray = new int[pattern.length()];
		patternArray[0] = 0;
		while (j < pattern.length()) {
			if (pattern.charAt(j) == pattern.charAt(i)) {
				patternArray[j] = patternArray[j - 1] + 1;
				i++;
				j++;
			} else {
				patternArray[j] = 0;
				j++;
			}
		}
		return patternArray;
	}

	public static void main(String[] args) {
		System.out.println(knuthMorrisPrattAlgorithm("aefoaefcdaefcdaed", "aefcdaed"));
	}
}
