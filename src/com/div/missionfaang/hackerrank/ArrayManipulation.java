package com.div.missionfaang.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
	Problem Statement:

		Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices,
		inclusive. Once all operations have been performed, return the maximum value in the array.

	Example
		n = 10
		queries = [[1,5,3], [4,8,7], 6,9,1]]
	
	Queries are interpreted as follows:
	
	    a b k
	    1 5 3
	    4 8 7
	    6 9 1
	Add the values of  between the indices  and  inclusive:
	
	index->	 1 2 3  4  5 6 7 8 9 10
		[0,0,0, 0, 0,0,0,0,0, 0]
		[3,3,3, 3, 3,0,0,0,0, 0]
		[3,3,3,10,10,7,7,7,0, 0]
		[3,3,3,10,10,8,8,8,1, 0]
	The largest value is 10 after all operations are performed.
	
	Function Description:
	
		Complete the function arrayManipulation in the editor below.
	
		arrayManipulation has the following parameters:
	
			int n - the number of elements in the array
			int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
			
		Returns
	
			int - the maximum value in the resultant array
			
		Input Format

			The first line contains two space-separated integers  and , the size of the array and the number of operations.
			Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.
			
		Constraints
			3 <= n <= 10to the power of 7
			1 <= m <= 2*10to the power of 5
			1 <= a <= b <= n
			0 <= k <= 10 to the power of 9 
		
		Sample Input
			
			5 3
			1 2 100
			2 5 100
			3 4 100
			
		Sample Output
			200
			
		Explanation
			
			After the first update the list is 100 100 0 0 0.
			After the second update list is 100 200 100 100 100.
			After the third update list is 100 200 200 200 100.
			
			The maximum value is 200.
 */

public class ArrayManipulation {

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int size, int[][] queries) {
		long[] array = new long[size];
		for (int i = 0; i < queries.length; i++) {
			array[queries[i][0] - 1] += queries[i][2];
			if (queries[i][1] < size) {
				array[queries[i][1]] += -queries[i][2];
			}
		}
		long maxValue = array[0];
		for (int i = 1; i < array.length; i++) {
			array[i] += array[i - 1];
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
