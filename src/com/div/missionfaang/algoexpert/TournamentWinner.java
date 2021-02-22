package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {
	public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		// Write your code here.
		int maxScore = Integer.MIN_VALUE;
		HashMap<String, Integer> points = new HashMap<>();
		String winningTeam = "";
		for (int i = 0; i < competitions.size(); i++) {
			if (points.containsKey((competitions.get(i).get(0)))) {
				points.put(competitions.get(i).get(0),
						points.get(competitions.get(i).get(0)).intValue() + (results.get(i) < 1 ? 0 : 3));
				if (maxScore < points.get(competitions.get(i).get(0))) {
					winningTeam = competitions.get(i).get(0);
					maxScore = points.get(competitions.get(i).get(0));
				}
			} else {
				points.put(competitions.get(i).get(0), (results.get(i) < 1 ? 0 : 3));
				if (maxScore < points.get(competitions.get(i).get(0))) {
					winningTeam = competitions.get(i).get(0);
					maxScore = points.get(competitions.get(i).get(0));
				}
			}
			if (points.containsKey((competitions.get(i).get(1)))) {
				points.put(competitions.get(i).get(1),
						points.get(competitions.get(i).get(1)).intValue() + (results.get(i) < 1 ? 3 : 0));
				if (maxScore < points.get(competitions.get(i).get(1))) {
					winningTeam = competitions.get(i).get(1);
					maxScore = points.get(competitions.get(i).get(1));
				}
			} else {
				points.put(competitions.get(i).get(1), (results.get(i) < 1 ? 3 : 0));
				if (maxScore < points.get(competitions.get(i).get(1))) {
					winningTeam = competitions.get(i).get(1);
					maxScore = points.get(competitions.get(i).get(1));
				}
			}
		}
		return winningTeam;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> competitions = new ArrayList<>();
		ArrayList<String> competition = new ArrayList<>();
		competition.add("HTML");
		competition.add("C#");
		competitions.add(competition);

		competition = new ArrayList<>();
		competition.add("C#");
		competition.add("Python");
		competitions.add(competition);

		competition = new ArrayList<>();
		competition.add("Python");
		competition.add("HTML");
		competitions.add(competition);

		ArrayList<Integer> results = new ArrayList<>();
		results.add(0);
		results.add(0);
		results.add(1);

		System.out.println(tournamentWinner(competitions, results));
	}
}
