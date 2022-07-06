package com.div.missionfaang.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Waiter {

    private static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
        int[] waiter = new int[number.length];
        List<Integer> nPrimes = Waiter.getNPrimes(q);
        int waiterCount = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length; i++) {
            stack.push(number[i]);
        }
        for (Integer integer : nPrimes) {
            Stack<Integer> newStack = new Stack<>();
            Stack<Integer> answerStack = new Stack<>();
            while (!stack.isEmpty()) {
                Integer currNumber = stack.pop();
                if (currNumber % integer == 0) {
                    answerStack.push(currNumber);
                } else {
                    newStack.push(currNumber);
                }
            }
            while (!answerStack.isEmpty()) {
                waiter[waiterCount++] = answerStack.pop();
            }
            stack = newStack;
        }
        if (!stack.isEmpty()) {
            do {
                waiter[waiterCount++] = stack.pop();
            } while (!stack.isEmpty());
        }
        return waiter;
    }

    private static List<Integer> getNPrimes(int q) {
        ArrayList<Integer> primes = new ArrayList<>(25);
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(29);
        primes.add(31);
        primes.add(37);
        primes.add(41);
        primes.add(43);
        primes.add(47);
        primes.add(53);
        primes.add(59);
        primes.add(61);
        primes.add(67);
        primes.add(71);
        primes.add(73);
        primes.add(79);
        primes.add(83);
        primes.add(89);
        primes.add(97);

        if (q < primes.size()) {
            return primes.subList(0, q);
        } else {
            for (int i = 101; primes.size() < q; i++) {
                boolean prime = true;
                for (int j = 0; j < primes.size() && primes.get(j) < i / 2; ++j) {
                    if (i % primes.get(j) == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    primes.add(i);
                }
            }
            return primes;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Waiter.waiter(new int[]{3, 3, 4, 4, 9}, 3)));
    }
}
