package com.div.missionfaang.scaler.advanced.prime;

import java.util.ArrayList;

public class PrimeNumberProblems {

    private static ArrayList<Integer> countOfDivisors(ArrayList<Integer> A) {
        int sum = A.size() * 2;
        return new ArrayList<>();
    }

    /**
     * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
     * <p>
     * If there is more than one solution possible, return the lexicographically smaller solution.
     * <p>
     * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
     * [a, b] < [c, d], If a < c OR a==c AND b < d.
     * <p>
     * NOTE: A solution will always exist. Read Goldbach's conjecture.
     * <p>
     * Approach : Build the "Seive of Eratosthenes"
     *
     * @param A
     * @return
     */
    private static ArrayList<Integer> primesum(int A) {
        // Considering the array size to be 1 greater than A to avoid the
        // loop increment complications. Hence 0 and 1 are also in effect
        // considered as primes. This needs to be handled while consuming
        // the seive.
        boolean[] seive = new boolean[A + 1];
        seive[0] = false;
        seive[1] = false;
        // Running the loop starting from 2 to sqrt(A) because, beyond the sqrt(A) will be
        // definitely greater than A.
        for (int i = 2; i * i <= A; i++) {
            for (int j = i * i; j < A; j += i) {
                seive[j] = true;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 2; j < A; j++) {
            if (!seive[j] && !seive[A - j]) {
                result.add(j);
                result.add(A - j);
                break;
            }
        }
        return result;
    }

    /**
     * A lucky number is a number that has exactly 2 distinct prime divisors.
     * <p>
     * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
     *
     * @param A
     * @return
     */
    private static int luckyNumbers(int A) {
        int[] seive = new int[A + 1];
        seive[0] = 0;
        seive[1] = 0;
        // Running the loop starting from 2 to sqrt(A) because, beyond the sqrt(A) will be
        // definitely greater than A.
        for (int i = 2; i <= A; i++) {
            if (seive[i] == 0) {
                for (int j = i; j <= A; j += i) {
                    seive[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (seive[i] == 2) {
                count++;
            }
        }
        return count;
    }

    /**
     * You are given an even number N and you need to represent the given number as the sum of primes.
     * The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.
     * You need to determine the minimum number of prime numbers needed to represent the given number.
     * <p>
     * Input : The first argument contains an integer N,the number you need to represent (2<=N<=10^9).
     * Output : Return an integer which is the minimum number of prime numbers needed to represent the given number N.
     * Examples
     * <p>
     * Input : 26
     * Output : 2
     * <p>
     * Explanation
     * <p>
     * You can represent 26 as: 13+13
     * So we require minimum of 2 prime numbers to represent the number 26.
     * <p>
     * Approach : As per "Goldbach's conjecture" any large even number can be represented as sum of two prime numbers.
     * Prime numbers need not be distinct.
     * <p>
     * Given that theory, we know that minimum numbers needed to add are 2, except for the case of 2, where 1 is not co
     *
     * @param A
     * @return
     */
    private static int primeAddition(int A) {
        if (A > 2) {
            return 2;
        }
        return 1;
    }

    /**
     * Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.
     * <p>
     * A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.
     * <p>
     * In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
     * In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
     * In the third go, he/she alters the states of doors numbered 3, 6, 9 …
     * This continues till the A'th go in, which you alter the state of the door numbered A.
     * <p>
     * Find and return the number of open doors at the end of the procedure.
     * <p>
     * Approach :
     * When we take a sample test data for 1 - 100, after all the 100 cycles are completed, we can observe that only the perfect squares remain open.
     *
     * @param A
     * @return
     */
    private static int solve(int A) {
        int count = 1;
        for (int i = 2; i * i <= A; i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(PrimeNumberProblems.luckyNumbers(9));
    }
}
