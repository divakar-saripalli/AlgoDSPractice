package com.div.mission.faang.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'componentsInGraph' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * 2D_INTEGER_ARRAY gb as parameter.
	 */

	public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
		// Write your code here
		List<Integer> result = new ArrayList<Integer>(2);
		result.add(0);
		result.add(0);
		int min = gb.size();
		int max = 0;

		if (min == 0) {
			return result;
		}

		if (min == 1) {
			result.set(0, 1);
			result.set(1, 1);
			return result;
		}

		int currentEdges = 0;
		int currentIndex = getNodeIndexToProcess(gb);
		List<Integer> sourceIndices = new ArrayList<>();
		List<Integer> targetIndices = new ArrayList<>();
		while (currentIndex != -1) {

			int currentNodeValue = gb.get(currentIndex).get(1);
			targetIndices.add(currentIndex);
			gb.get(currentIndex).set(0, 0);
			gb.get(currentIndex).set(0, 1);
			currentEdges++;

			for (int i = 0; i < gb.size(); i++) {
				if (gb.get(i).get(1) != currentNodeValue) {
					if (currentNodeValue != gb.get(currentIndex).get(0) && currentNodeValue < gb.size())
						sourceIndices.add(i);
				}
				currentEdges++;
				gb.get(currentIndex).set(0, 0);
				gb.get(currentIndex).set(1, 0);
			}

			for (int i = 0; i < sourceIndices.size(); i++) {
				if (gb.get(sourceIndices.get(i)).get(0) != 0) {
					gb.get(sourceIndices.get(i)).set(0, 0);
					targetIndices.add(i);
					gb.get(sourceIndices.get(i)).set(1, 0);
					currentEdges++;
				}
			}

			if (currentEdges < min) {
				min = currentEdges;
			}

			if (currentEdges > max) {
				max = currentEdges;
			}

			currentIndex = getNodeIndexToProcess(gb);
			currentEdges = 0;
		}
		result.set(0, min);
		result.set(1, max);
		return result;
	}

	public static int getNodeIndexToProcess(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get(0) != 0) {
				return i;
			}
		}
		return -1;
	}
}

public class ComponentsInGraph {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> gb = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				gb.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = Result.componentsInGraph(gb);

		bufferedWriter.write(result.stream().map(Object::toString).collect(Collectors.joining(" ")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
