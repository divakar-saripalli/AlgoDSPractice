package com.div.missionfaang.hackerrank;

import java.io.IOException;
import java.util.Scanner;

/*
	There are a number of plants in a garden. Each of the plants has been treated with some amount of pesticide.
	After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.
	You are given the initial values of the pesticide in each of the plants. 
	Determine the number of days after which no plant dies, i.e. the time after which there is no plant with more pesticide content than the plant to its left.
	
	Example
		p=[3, 6, 2, 7, 5]// pesticide levels
	
	Use a 1-indexed array. On day 1, plants 2 and 4 die leaving p1 = [3, 2, 5]. On day , plant  in  dies leaving p2 = [3, 2].
	There is no plant with a higher concentration of pesticide than the one to its left, so plants stop dying after day 2.
	
	Function Description
		Complete the function poisonousPlants in the editor below.
	
		poisonousPlants has the following parameter(s):
	
			int p[n]: the pesticide levels in each plant
		
		Returns
			- int: the number of days until plants no longer die from pesticide
	
	Input Format
	
		The first line contains an integer n, the size of the array p.
		The next line contains n space-separated integers p[i].
	
	Constraints
		1 <= n <= 10 to the power of 5
		0 <= p[i] <= 10 to the power of 9
	
	Sample Input
	
		7
		6 5 8 4 7 10 9
	
	Sample Output
		2
	
	Explanation
	
		Initially all plants are alive.
		
		Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}
		
		Plants[k] = (i,j) => jth plant has pesticide amount = i.
		
		After the 1st day, 4 plants remain as plants 3, 5, and 6 die.
		
		Plants = {(6,1), (5,2), (4,4), (9,7)}
		
		After the 2nd day, 3 plants survive as plant 7 dies.
		
		Plants = {(6,1), (5,2), (4,4)}
		
		Plants stop dying after the 2nd day.
*/

public class PoisinousPlant {

	// TODO: This is working but time limit exceeded.
	static int poisonousPlants(int[] p) {
		if (p.length < 2) {
			return 0;
		}

		boolean plantDiesToday = false;
		int totalDaysPlantsDying = 0;

		int startIndex = 0;
		for (int i = 1; i < p.length - 1; i++) {
			if (p[i] > p[i - 1]) {
				startIndex = i - 1;
				break;
			}
		}

		do {
			plantDiesToday = false;
			int indexToCompare = startIndex;
			for (int i = 1; i < p.length; i++) {
				if (p[i] > 0) {
					if (p[i] > Math.abs(p[indexToCompare])) {
						plantDiesToday = true;
						p[i] = p[i] * -1;
					}
					indexToCompare = i;
				}
			}
			if (plantDiesToday) {
				totalDaysPlantsDying++;
			}
		} while (plantDiesToday);

		return totalDaysPlantsDying;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] p = new int[n];

		String[] pItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pItem = Integer.parseInt(pItems[i]);
			p[i] = pItem;
		}

		System.out.println(poisonousPlants(p));

		scanner.close();
	}
}
