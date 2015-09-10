package com.testdouble.gameoflife;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
		World seedWorld = new World();
		when(generatesSeedWorld.generate()).thenReturn(seedWorld);
		
		subject.simulate(0, 1337);
			
		verify(outputsWorld).output(seedWorld);
	}
	
	@Test
	public void oneGeneration() {
		World seedWorld = new World();
		when(generatesSeedWorld.generate()).thenReturn(seedWorld);
		World world2 = new World();
		when(replacesWorld.replace(seedWorld, 1337)).thenReturn(world2);
		
		subject.simulate(1, 1337);
			
		verify(outputsWorld).output(seedWorld);
		verify(outputsWorld).output(world2);
	}
	
	
	
}