package com.testdouble.gameoflife.values;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.replace.Coordinates;

public class MutableWorld extends World {

	public void set(Coordinates coordinates, Contents contents) {
		population.put(coordinates, contents); 
	}
	
	public Contents at(Coordinates coordinates) {
		return population.get(coordinates);
	}
	
}
