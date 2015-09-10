package com.testdouble.gameoflife.replace.cell;

import java.util.Collection;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.values.Cell;
import com.testdouble.gameoflife.values.Nothing;
import com.testdouble.gameoflife.values.Point;

public class DeterminesNextContents {

	public Contents determine(Contents oldContents, Collection<Point> neighbors) {
		switch(countLiveOnes(neighbors)) {
			case 2:
				return oldContents instanceof Cell ? new Cell() : new Nothing();
			case 3:
				return new Cell();
			default:
				return new Nothing();
		}
	}

	private int countLiveOnes(Collection<Point> neighbors) {
		int i = 0;
		for(Point point : neighbors) {
			if(point.contents instanceof Cell) {
				i++;
			}
		}
		return i;
	}

}
