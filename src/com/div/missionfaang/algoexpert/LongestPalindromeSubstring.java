package src.com.div.missionfaang.algoexpert;

public class LongestPalindromeSubstring {

    public static String longestPalindromicSubstring(String str) {
	// Write your code here.
	if(str.length() < 2){
	    return str;
	}
	int start = 0;
	int end = str.length() - 1;
	boolean foundPalindrome = false;
	for(int i = 0; i < end; i++){
	}
	return "";
    }

    public static void main(String[] args) {
	System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }
}
