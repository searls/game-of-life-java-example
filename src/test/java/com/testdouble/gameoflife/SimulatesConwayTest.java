package com.testdouble.gameoflife;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.testdouble.gameoflife.replace.ReplacesWorld;
import com.testdouble.gameoflife.values.MutableWorld;
import com.testdouble.gameoflife.values.World;

@RunWith(MockitoJUnitRunner.class)
public class SimulatesConwayTest {

	@InjectMocks
	SimulatesConway subject;
	
	@Mock
	GeneratesSeedWorld generatesSeedWorld;
	
	@Mock
	ReplacesWorld replacesWorld;
	
	@Mock
	OutputsWorld outputsWorld;
	
	@Test
	public void zeroGenerations() {
		World seedWorld = new MutableWorld();
		when(generatesSeedWorld.generate()).thenReturn(seedWorld);
		
		subject.simulate(0, 1337);
			
		verify(outputsWorld).output(seedWorld);
	}
	
	@Test
	public void oneGeneration() {
		World seedWorld = new MutableWorld();
		when(generatesSeedWorld.generate()).thenReturn(seedWorld);
		World world2 = new MutableWorld();
		when(replacesWorld.replace(seedWorld, 1337)).thenReturn(world2);
		
		subject.simulate(1, 1337);
			
		verify(outputsWorld).output(seedWorld);
		verify(outputsWorld).output(world2);
	}
	
	
	
}