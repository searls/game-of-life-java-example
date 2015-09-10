package com.testdouble.gameoflife.replace.cell;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.replace.Coordinates;
import com.testdouble.gameoflife.replace.Outcome;
import com.testdouble.gameoflife.values.MutableWorld;
import com.testdouble.gameoflife.values.Point;

@RunWith(MockitoJUnitRunner.class)
public class ReplacesCellTest {

	@InjectMocks
	ReplacesCell subject;
	
	@Mock
	GathersNeighbors gathersNeighbors;
	
	@Mock 
	DeterminesNextContents determinesNextContents;

	@Test
	public void test() {
		MutableWorld world = new MutableWorld();
		Contents oldContents = new Contents();
		Coordinates coordinates = new Coordinates(1337, 1337);
		world.set(coordinates, oldContents);
		Collection<Point> neighbors = new ArrayList<Point>();
		when(gathersNeighbors.gather(coordinates, world)).thenReturn(neighbors);
		Contents newContents = new Contents();		
		when(determinesNextContents.determine(oldContents , neighbors)).thenReturn(newContents);
		
		Outcome result = subject.replace(coordinates, world);		
		
		assertThat(result.neighbors, is(neighbors));
		assertThat(result.nextContents, is(newContents));
	}
}