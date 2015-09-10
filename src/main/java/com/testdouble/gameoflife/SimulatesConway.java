package com.testdouble.gameoflife;

import com.testdouble.gameoflife.replace.ReplacesWorld;
import com.testdouble.gameoflife.values.World;

public class SimulatesConway {

	GeneratesSeedWorld generatesSeedWorld;
	ReplacesWorld replacesWorld;
	OutputsWorld outputsWorld;
	
	public void simulate(int generations, int timeLimit) {
		World world = generatesSeedWorld.generate();		
		for(int i=0;i<generations;i++) {
			outputsWorld.output(world);
			world = replacesWorld.replace(world, timeLimit);
		}		
		outputsWorld.output(world);
	}

}
