package com.div.missionfaang.algoexpert;

import java.util.HashMap;

public class LongestSubstringWithoutDups {

	public static String longestSubstringWithoutDuplication(String str) {
		// Write your code here
		String result = "";
		int startIndex = 0;
		HashMap<Character, Integer> charsFoundEarlier = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (charsFoundEarlier.containsKey(c)) {
				String currentMaxString = str.substring(startIndex, i);
				if (currentMaxString.length() > result.length()) {
					result = currentMaxString;
				}
				startIndex = Math.max(startIndex, charsFoundEarlier.get(c) + 1);
			} else {
			}
			charsFoundEarlier.put(c, i);
		}
		if (str.substring(startIndex, str.length()).length() > result.length()) {
			return str.substring(startIndex, str.length());
		}
		return (result.isEmpty()) ? str : result;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstringWithoutDuplication("abcbde"));
	}
}
