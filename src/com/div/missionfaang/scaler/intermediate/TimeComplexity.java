package com.div.missionfaang.scaler.intermediate;

import java.util.Scanner;

public class TimeComplexity {
    private static int squareRoot(Integer A) {
        long start = 1;
        long end = A;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid == Long.valueOf(A)) {
                return (int) mid;
            } else if (mid * mid > A) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static void summation() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println((N * (N + 1)) / 2);
    }

    private static void isPerfectNumber() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int count = 1;
            int pivot = (int) Math.ceil(Math.sqrt(N));
            for (int j = 2; j <= pivot; j++) {
                if (N % j == 0 && (j <= N / j)) {
                    count += j;
                    if (N / j != j) {
                        count += N / j;
                    }
                }
            }
            System.out.println((count == N) ? "YES" : "NO");
        }
    }

    private static void isPrime() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int pivot = (int) Math.ceil(Math.sqrt(N));
        boolean isPrime = true;
        for (int j = 2; j <= pivot; j++) {
            if (N % j == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "YES" : "NO");
    }

    public static void main(String[] args) {
        TimeComplexity.isPrime();
    }
}
