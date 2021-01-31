package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumberMnemonics {

	public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
		// Write your code here.
		HashMap<Integer, String> digitCharMap = new HashMap<>();
		digitCharMap.put(0, "");
		digitCharMap.put(1, "");
		digitCharMap.put(2, "abc");
		digitCharMap.put(3, "def");
		digitCharMap.put(4, "ghi");
		digitCharMap.put(5, "jkl");
		digitCharMap.put(6, "mno");
		digitCharMap.put(7, "pqrs");
		digitCharMap.put(8, "tuv");
		digitCharMap.put(9, "wxyz");

		int combinations = 1;
		for (int i = 0; i < phoneNumber.length(); i++) {
			char digit = phoneNumber.charAt(i);
			String possibleChars = digitCharMap.get(Integer.parseInt(String.valueOf(digit)));
			if (possibleChars.length() != 0) {
				combinations *= possibleChars.length();
			}
		}

		ArrayList<String> result = new ArrayList<String>(combinations);
		for (int j = 0; j < combinations; j++) {
			result.add(j, "");
		}
		for (int i = 0; i < phoneNumber.length(); i++) {
			char digit = phoneNumber.charAt(i);
			String possibleChars = digitCharMap.get(Integer.parseInt(String.valueOf(digit)));
			for (int j = 0, k = 0; j < combinations; j++) {
				if (possibleChars.isEmpty()) {
					result.set(j, result.get(j) + digit);
				} else {
					if (k == possibleChars.length()) {
						k = 0;
					}
					result.set(j, result.get(j) + possibleChars.charAt(k));
					k++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(phoneNumberMnemonics("1905").toString());
	}
}
