package com.div.missionfaang.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StockMax {
    private static long stockmax(List<Integer> prices) {
//		long currMax = prices.get(prices.size() - 1);
//		long currExp = 0;
//		long currStocks = 0;
//		long profit = 0;
//		int currMaxIdx = prices.size() - 1;
//
//		while (currMaxIdx > 0) {
//			if (prices.get(currMaxIdx) < currMax) {
//				currMax = prices.get(currMaxIdx);
//				currStocks++;
//				currExp += currMax;
//			} else {
//				long currCash = prices.get(currMaxIdx) * currStocks;
//				profit += currCash - currExp;
//				currStocks = 0;
//				currExp = 0;
//			}
//			currMaxIdx--;
//		}
//		profit += (prices.get(currMaxIdx) * currStocks) - currExp;
//		return profit;

        int profit = 0;
        int stocks = 0;
        int expense = 0;
        for (int i = prices.size() - 1; i > 0; i--) {
            if (prices.get(i) > prices.get(i - 1)) {
                profit += (prices.get(i) - prices.get(i - 1)) * stocks;
                profit -= expense;
            } else {
                expense += prices.get(i);
                stocks++;
            }
        }
        return profit;
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        // Write your code here.
        int profit = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

                System.out.println(StockMax.stockmax(prices));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
