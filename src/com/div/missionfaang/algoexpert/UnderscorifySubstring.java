package com.div.missionfaang.algoexpert;

public class UnderscorifySubstring {

	public static String underscorifySubstring(String str, String substring) {
		// Write your code here.
		int startIndex = 0;
		int noOfMultipleSubseuences = 0;

		if (substring.length() == 0) {
			return str;
		}
		for (int i = 0; i < str.length(); i++) {
			int substringIndex = 0;
			if (str.charAt(i) == substring.charAt(substringIndex)) {
				while (i < str.length() && str.charAt(i) == substring.charAt(substringIndex)) {
					i++;
					substringIndex++;
					if (substringIndex % substring.length() == 0) {
						substringIndex = 0;
						noOfMultipleSubseuences++;
					}
				}
				if (noOfMultipleSubseuences > 0) {
					String initialString = str.substring(0, startIndex);
					int endIndex = startIndex + (noOfMultipleSubseuences * substring.length());
					String stringToUnderscorify = str.substring(startIndex, endIndex);
					stringToUnderscorify = "_" + stringToUnderscorify + "_";
					String finalString = str.substring(endIndex, str.length());
					str = initialString + stringToUnderscorify + finalString;
					startIndex = i + 1;
					noOfMultipleSubseuences = 0;
				}
			} else {
				startIndex = i + 1;
			}
		}
		return str;
	}

	public static void main(String[] args) {
//		testthis is a testtest to see if testestest it works
//		DivakarMahiMahiAksharaMahi
		System.out.println(underscorifySubstring("testthis is a testtest to see if testestest it works", "test"));
	}
}
