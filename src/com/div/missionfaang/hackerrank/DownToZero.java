package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class DownToZero {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the downToZero function below.
     */
    private static int downToZero(int n) {
        /*
         * Write your code here.
         */

        if (n < 4) {
            return n;
        }

        int count = 0;
        while (n >= 4) {
            System.out.println("Number is :: " + n);
            if (DownToZero.isPrime(n)) {
                n--;
                System.out.println("Prime number detected and hence reduced by 1 :: " + n);
                count++;
            } else {
                double dub = n;
                double sqrt = Math.sqrt(dub);
                int a = (int) Math.ceil(sqrt);
                System.out.println("Square root is :: " + sqrt);
                System.out.println("Maximum divisor is :: " + a);
                System.out.println("=======================================");
                int j = a;
                for (; (j * j != n && n % j != 0); j++) {
                    System.out.println("Maximum divisor is :: " + j);
                }
                System.out.println("Maximum divisor is :: " + j);
                n = j;
                System.out.println("#####################################");
            }
            count++;
        }
        count += n;
        return count;
    }

    private static boolean isPrime(int n) {
        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        int q = Integer.parseInt(DownToZero.scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(DownToZero.scanner.nextLine().trim());
            int result = DownToZero.downToZero(n);
            System.out.println(result);
        }
    }
}
