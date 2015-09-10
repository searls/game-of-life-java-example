package com.testdouble.gameoflife.replace;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.testdouble.gameoflife.replace.cell.ReplacesCell;
import com.testdouble.gameoflife.values.MutableWorld;
import com.testdouble.gameoflife.values.Point;
import com.testdouble.gameoflife.values.World;

@RunWith(MockitoJUnitRunner.class)
public class ReplacesWorldTest {

	@InjectMocks
	ReplacesWorld subject;
	
	@Mock
	KeepsTime keepsTime;
	
	@Mock
	ReplacesCell replacesCell;
	
	@Test
	public void testForOneCellToBeReplaced() {
		TimeLimit timeLimit = mock(TimeLimit.class);
		when(timeLimit.timesUp()).thenReturn(false, true);
		when(keepsTime.keep(42l)).thenReturn(timeLimit);
		World world1 = new MutableWorld();
		Contents nextContents = new Contents();
		Outcome outcome = new Outcome(nextContents, new ArrayList<Point>());
		when(replacesCell.replace(new Coordinates(0,0), world1)).thenReturn(outcome);
		
		World result = subject.replace(world1 , 42l);
		
		assertThat(result.at(new Coordinates(0,0)), is(nextContents));
	}
	
	@Test
	public void testForTwoCellsToBeReplaced() {
		TimeLimit timeLimit = mock(TimeLimit.class);
		when(timeLimit.timesUp()).thenReturn(false, false, true);
		when(keepsTime.keep(42l)).thenReturn(timeLimit);
		World world1 = new MutableWorld();
		Contents nextContents = new Contents();
		Collection<Point> neighbors = Arrays.asList(new Point(null, new Coordinates(50,50)));
		Outcome outcome = new Outcome(nextContents, neighbors);
		when(replacesCell.replace(new Coordinates(0,0), world1)).thenReturn(outcome);
		Contents nextContents2= new Contents();
		Outcome outcome2 = new Outcome(nextContents2, new ArrayList<Point>());
		when(replacesCell.replace(new Coordinates(50,50), world1)).thenReturn(outcome2);

		World result = subject.replace(world1 , 42l);
		
		assertThat(result.at(new Coordinates(0,0)), is(nextContents));
		assertThat(result.at(new Coordinates(50,50)), is(nextContents2));
	}
	
}