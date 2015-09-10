package com.testdouble.gameoflife.replace;

import java.util.Collection;

public class Outcome {

	Contents nextContents;
	Collection<Coordinates> neighbors;

	public Outcome(Contents contents, Collection<Coordinates> neighbors) {
		this.nextContents = contents;
		this.neighbors = neighbors;
	}

}
