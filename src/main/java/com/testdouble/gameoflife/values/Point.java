package com.testdouble.gameoflife.values;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.replace.Coordinates;

public class Point {

	public Contents contents;
	public Coordinates coordinates;
	
	public Point(Contents contents, Coordinates coordinates) {
		this.contents = contents;
		this.coordinates = coordinates;
	}
	
}
