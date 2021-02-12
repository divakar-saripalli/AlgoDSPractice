package com.div.missionfaang.educative;

import java.util.HashMap;

public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		// TODO: Write your code here
		int startIndex = 0;
		int endIndex = 0;
		int longestSubstring = Integer.MIN_VALUE;
		HashMap<Character, Integer> charsCount = new HashMap<>();
		while (endIndex < str.length()) {
			char character = str.charAt(endIndex);
			if (charsCount.size() == k && !charsCount.containsKey(character)) {
				int currSize = endIndex - startIndex;
				longestSubstring = Math.max(currSize, longestSubstring);
				while (charsCount.size() >= k) {
					char c = str.charAt(startIndex);
					Integer charCount = charsCount.get(c);
					if (charCount > 1) {
						charsCount.put(c, charCount - 1);
					} else {
						charsCount.remove(c);
					}
					startIndex++;
				}
			}
			if (charsCount.containsKey(character)) {
				Integer charCount = charsCount.get(character);
				charsCount.put(character, charCount + 1);
			} else {
				charsCount.put(character, 1);
			}
			endIndex++;
		}
		int currSize = endIndex - startIndex;
		return Math.max(currSize, longestSubstring);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLength("araaci", 1));
	}

}
