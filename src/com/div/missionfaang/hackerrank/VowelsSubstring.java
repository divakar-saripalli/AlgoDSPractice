package com.div.missionfaang.hackerrank;

public class VowelsSubstring {

    private static String findSubstring(String s, int k) {
        // Write your code here
        boolean vowelExists = false;
        for (int i = 0; i < s.length(); i++) {
            if (VowelsSubstring.isVowel(s.charAt(i))) {
                vowelExists = true;
                break;
            }
        }

        if (vowelExists) {
            String substring = s.substring(0, k);
            int vowelsCounter = 0;
            int maxVowelsCount = 0;
            for (int i = 0; i < substring.length(); i++) {
                if (VowelsSubstring.isVowel(s.charAt(i))) {
                    vowelsCounter++;
                }
            }
            int startIndex = 0;
            maxVowelsCount = vowelsCounter;
            for (int i = k, j = 0; i < s.length(); i++, j++) {
                if (VowelsSubstring.isVowel(s.charAt(j)) && !VowelsSubstring.isVowel(s.charAt(i))) {
                    vowelsCounter--;
                } else if (!VowelsSubstring.isVowel(s.charAt(j)) && VowelsSubstring.isVowel(s.charAt(i))) {
                    vowelsCounter++;
                }

                if (maxVowelsCount < vowelsCounter) {
                    maxVowelsCount = vowelsCounter;
                    startIndex = j + 1;
                }
            }
            String finalString = s.substring(startIndex, k);
            return finalString;
        } else {
            return "Not found";
        }
    }

    private static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }

    public static void main(String[] args) {
        System.out.println(VowelsSubstring.findSubstring("azerdii", 5));
    }
}
