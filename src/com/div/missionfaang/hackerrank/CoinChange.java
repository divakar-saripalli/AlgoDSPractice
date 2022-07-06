package com.div.missionfaang.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    private static long getWays(int n, List<Long> c) {
        // Write your code here
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        List<Long> c = new ArrayList<>();
        Arrays.stream(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).forEach(s -> c.add(Long.parseLong(s)));
        System.out.println(CoinChange.getWays(n, c));
        bufferedReader.close();
    }
}
