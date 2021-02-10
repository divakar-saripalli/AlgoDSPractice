package com.div.missionfaang.algoexpert;

public class ReverseWordsInAString {

	public String reverseWordsInString(String string) {
		// Write your code here.
		if (string.length() < 2) {
			return string;
		}
		char[] stringArray = string.toCharArray();
		for (int i = 0, j = stringArray.length - 1; i < j; i++, j--) {
			char temp = stringArray[i];
			stringArray[i] = stringArray[j];
			stringArray[j] = temp;
		}

		for (int i = 0, j = 0; j < stringArray.length;) {
			if (stringArray[j] != ' ') {
				j++;
				if (j != stringArray.length) {
					continue;
				} else {
					i = swapWord(stringArray, i, j);
				}
			} else {
				i = swapWord(stringArray, i, j);
				while (stringArray[j] == ' ') {
					j++;
				}
				i = j;
			}
		}
		return new String(stringArray);
	}

	private int swapWord(char[] stringArray, int i, int j) {
		j = j - 1;
		while (i < j) {
			char temp = stringArray[i];
			stringArray[i] = stringArray[j];
			stringArray[j] = temp;
			i++;
			j--;
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInAString obj = new ReverseWordsInAString();
		System.out.println(obj.reverseWordsInString("Tim is Great"));
	}

}
