package com.div.missionfaang.practice;

import java.util.ArrayList;
import java.util.List;

public class TimeComplexity {
    static int calcLoops(int n) {
	int count = 0;
	for (int i = n; i > 0; i /= 2)
	    for (int j = 0; j < i; j++)
		count += 1;
	return count;
    }

    private static int search(List<Integer> A, int B) {
	if (A.isEmpty())
	    return -1;
	if (A.size() < 2)
	    return A.get(0) == B ? 0 : -1;
	if (B == A.get(0))
	    return 0;
	if (B == A.get(A.size() - 1))
	    return A.size() - 1;
	boolean isGreaterThanFirstElem = (B > A.get(0));
	boolean isLesserThanLastElem = (B < A.get(A.size() - 1));
	int pivot = TimeComplexity.findPivot(A);
	int start = (isGreaterThanFirstElem) ? 0 : pivot;
	int end = (isLesserThanLastElem) ? A.size() - 1 : pivot;
	while (start <= end && start < A.size() && end > -1) {
	    int mid = (end + start) / 2;
	    Integer midValue = A.get(mid);
	    if (midValue == B)
		return mid;
	    if (midValue > B)
		end = mid - 1;
	    if (midValue < B)
		start = mid + 1;
	}
	return -1;
    }

    private static int findPivot(List<Integer> A) {
	int start = 0;
	int end = A.size() - 1;
	Integer lastValue = A.get(A.size() - 1);
	Integer firstValue = A.get(0);
	int mid = 0;
	while (start < end) {
	    mid = (start + end) / 2;
	    Integer midValue = A.get(mid);
	    if ((midValue < lastValue) && (mid > 0 && midValue > A.get(mid - 1)))
		end = mid;
	    else if ((midValue > firstValue) && (mid < A.size() && midValue < A.get(mid + 1)))
		start = mid;
	    else
		break;
	}
	return mid;
    }

    private static ArrayList<Integer> prefixMatching(ArrayList<String> A, String B) {
	ArrayList<Integer> indices = new ArrayList<>();
	int i = 0;
	for (String string : A) {
	    if (string.length() >= B.length()) {
		String substring = string.substring(0, B.length());
		if (substring.equalsIgnoreCase(B))
		    if (indices.size() < 1) {
			indices.add(i);
			indices.add(i);
		    } else
			indices.set(1, i);
	    }
	    i++;
	}
	if (indices.size() < 2) {
	    indices.add(-1);
	    indices.add(-1);
	}
	return indices;
    }

    public static void main(String[] args) {
	int[] arr = { 186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40, 41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74,
			77, 78, 80, 82, 83, 88, 89, 90, 94, 100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138, 144, 147, 148,
			150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183, 185 };
	ArrayList<Integer> list = new ArrayList<>();
	for (int j = 0; j < arr.length; j++)
	    list.add(arr[j]);
	//		System.out.println(findPivot(list));
	System.out.println(TimeComplexity.search(list, 6));
	//		System.out.println(generateMatrix(1));
	ArrayList<String> A = new ArrayList<>();
	A.add("aaaaa");
	A.add("aaab");
	A.add("ab");
	A.add("b");
	System.out.println(TimeComplexity.prefixMatching(A, "b"));
    }

    public static int checkIfRectangle(int A, int B, int C, int D) {
	if (A == B && A == C && A == D)
	    return 1;
	if ((A == B && C == D) || (A == C && B == D) || (A == D && B == C))
	    return 1;
	return 0;
    }

    public static String longestSubsequenceVowels(String A) {
	StringBuffer vowelsSubString = new StringBuffer();
	for (int i = 0; i < A.length(); i++) {
	    char character = A.charAt(i);
	    if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
		vowelsSubString.append(character);
	}
	return vowelsSubString.toString();
    }

}
