package com.testdouble.gameoflife.replace.cell;

import java.util.Collection;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.replace.Coordinates;
import com.testdouble.gameoflife.replace.Outcome;
import com.testdouble.gameoflife.values.Point;
import com.testdouble.gameoflife.values.World;

public class ReplacesCell {

	GathersNeighbors gathersNeighbors;
	DeterminesNextContents determinesNextContents;

	public Outcome replace(Coordinates coordinates, World world) {
		Collection<Point> neighbors = gathersNeighbors.gather(coordinates, world);
		Contents newContents = determinesNextContents.determine(world.at(coordinates), neighbors);
		return new Outcome(newContents, neighbors);
	}

}
