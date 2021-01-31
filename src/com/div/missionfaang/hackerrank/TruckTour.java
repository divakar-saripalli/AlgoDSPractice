package com.div.missionfaang.hackerrank;

public class TruckTour {

	static int truckTour(int[][] petrolPumps) {
		/*
		 * Write your code here.
		 */

		int nextPump = 0;
		while (nextPump != petrolPumps.length) {
			int currentPump = nextPump;
			int currentPetrol = petrolPumps[currentPump][0];
			int distanceToTravel = petrolPumps[currentPump][1];
			while (currentPetrol > distanceToTravel) {
				currentPump++;

				if (currentPump == petrolPumps.length) {
					currentPump = 0;
				}

				if (currentPump == nextPump) {
					return nextPump;
				}

				currentPetrol -= distanceToTravel;
				distanceToTravel = petrolPumps[currentPump][1];
				currentPetrol += petrolPumps[currentPump][0];
			}
			nextPump++;
		}
		return -1;
	}

}
