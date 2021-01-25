package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {

		if (s.length() % 2 != 0) {
			return "NO";
		}

		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c.equals('(') || c.equals('{') || c.equals('[')) {
				brackets.push(c);
			} else if (c.equals(')') || c.equals('}') || c.equals(']')) {
				Character c1 = brackets.peek();
				if (Math.abs(c1 - c) > 1) {
					return "NO";
				} else {
					brackets.pop();
				}
			}
		}
		return "YES";
	}

	static String isBalanced1(String s) {

		if (s.length() % 2 != 0) {
			return "NO";
		}

		int n = 0;
		while (s.length() != n) {
			n = s.length();
			s = s.replace("[]", "");
			s = s.replace("{}", "");
			s = s.replace("()", "");
		}
		return s.length() != 0 ? "NO" : "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();
			System.out.println(isBalanced(s));
		}
		scanner.close();
	}
}
