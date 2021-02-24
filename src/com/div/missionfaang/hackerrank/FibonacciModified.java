package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	static int fibonacciModified(int t1, int t2, int n) {
		BigInteger number = BigInteger.valueOf(0);
		BigInteger bigT1 = BigInteger.valueOf(t1);
		BigInteger bigT2 = BigInteger.valueOf(t2);
		for (int i = 3; i <= n; i++) {
			number = bigT1.add(bigT2.pow(2));
			bigT1 = bigT2;
			bigT2 = number;
		}
		return number.intValue();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] t1T2n = scanner.nextLine().split(" ");

		int t1 = Integer.parseInt(t1T2n[0]);

		int t2 = Integer.parseInt(t1T2n[1]);

		int n = Integer.parseInt(t1T2n[2]);

		System.out.println(fibonacciModified(t1, t2, n));

		scanner.close();
	}
}
