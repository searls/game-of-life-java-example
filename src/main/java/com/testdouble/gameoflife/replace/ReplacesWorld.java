package com.testdouble.gameoflife.replace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.testdouble.gameoflife.values.MutableWorld;
import com.testdouble.gameoflife.values.World;

public class ReplacesWorld {

	KeepsTime keepsTime;
	ReplacesCell replacesCell;
	
	public World replace(World oldWorld, long timeLimitInMs) {
		MutableWorld newWorld = new MutableWorld();
		TimeLimit timeLimit = keepsTime.keep(timeLimitInMs);
		Queue<Coordinates> cellsToReplace = new LinkedList<Coordinates>(Arrays.asList(new Coordinates(0,0)));
		while(!cellsToReplace.isEmpty() && !timeLimit.timesUp()) {
			Coordinates coordinates = cellsToReplace.remove();
			Outcome outcome = replacesCell.replace(coordinates, oldWorld);
			newWorld.set(coordinates, outcome.nextContents);
			cellsToReplace.addAll(outcome.neighbors);
		}
		return newWorld;
	}

}
