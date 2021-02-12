package com.div.missionfaang.educative;

import java.util.HashMap;

public class MaxFruitCountOf2Types {

	public static int findLength(char[] arr) {
		// TODO: Write your code here
		int startIndex = 0;
		int endIndex = 0;
		int longestSubstring = Integer.MIN_VALUE;
		HashMap<Character, Integer> charsCount = new HashMap<>();
		int k = 2;
		while (endIndex < arr.length) {
			char character = arr[endIndex];
			if (charsCount.size() == k && !charsCount.containsKey(character)) {
				int currSize = endIndex - startIndex;
				longestSubstring = Math.max(currSize, longestSubstring);
				while (charsCount.size() >= k) {
					char c = arr[startIndex];
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
		System.out.println(findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
	}

}
