package com.testdouble.gameoflife.replace;

import java.util.Collection;

import com.testdouble.gameoflife.values.Point;

public class Outcome {

	public Contents nextContents;
	public Collection<Point> neighbors;

	public Outcome(Contents contents, Collection<Point> neighbors) {
		this.nextContents = contents;
		this.neighbors = neighbors;
	}

}
