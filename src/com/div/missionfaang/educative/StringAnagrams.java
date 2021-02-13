package com.div.missionfaang.educative;

import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {
	public static List<Integer> findStringAnagrams(String str, String pattern) {
		List<Integer> resultIndices = new ArrayList<Integer>();
		// TODO: Write your code here
		if (pattern.length() <= str.length() && pattern.length() > 0) {
			for (int i = 0; i <= str.length() - pattern.length(); i++) {
				String substring = str.substring(i, pattern.length() + i);
				substring += substring;
				if (substring.contains(pattern)) {
					resultIndices.add(i);
				}
			}
		}
		return resultIndices;
	}

	public static void main(String[] args) {
		System.out.println(findStringAnagrams("abbcabc", "abc"));
	}
}
