package com.testdouble.gameoflife.replace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.testdouble.gameoflife.replace.cell.ReplacesCell;
import com.testdouble.gameoflife.values.MutableWorld;
import com.testdouble.gameoflife.values.Point;
import com.testdouble.gameoflife.values.World;

public class ReplacesWorld {

	KeepsTime keepsTime;
	ReplacesCell replacesCell;
	
	public World replace(World oldWorld, long timeLimitInMs) {
		MutableWorld newWorld = new MutableWorld();
		TimeLimit timeLimit = keepsTime.keep(timeLimitInMs);
		Queue<Point> cellsToReplace = new LinkedList<Point>(Arrays.asList(new Point(null, new Coordinates(0,0))));
		while(!cellsToReplace.isEmpty() && !timeLimit.timesUp()) {
			Coordinates coordinates = cellsToReplace.remove().coordinates;
			Outcome outcome = replacesCell.replace(coordinates, oldWorld);
			newWorld.set(coordinates, outcome.nextContents);
			cellsToReplace.addAll(outcome.neighbors);
		}
		return newWorld;
	}

}
