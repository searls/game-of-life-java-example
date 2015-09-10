package com.testdouble.gameoflife.values;

import java.util.HashMap;
import java.util.Map;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.replace.Coordinates;

public abstract class World {
	protected Map<Coordinates, Contents> population = new HashMap<Coordinates, Contents>();

	public abstract Contents at(Coordinates coordinates);
}
