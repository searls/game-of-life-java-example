package com.testdouble.gameoflife.replace.cell;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.testdouble.gameoflife.replace.Contents;
import com.testdouble.gameoflife.values.Cell;
import com.testdouble.gameoflife.values.Nothing;
import com.testdouble.gameoflife.values.Point;

public class DeterminesNextContentsTest {

	DeterminesNextContents subject = new DeterminesNextContents();

	@Test
	public void testLiveCellsSurvival() {
		assertThat(subject.determine(new Cell(), liveNeighbors(0)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(1)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(2)), instanceOf(Cell.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(3)), instanceOf(Cell.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(4)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(5)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(6)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(7)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Cell(), liveNeighbors(8)), instanceOf(Nothing.class));
	}
	
	@Test 
	public void testDeadCellsUndeadedness() {
		assertThat(subject.determine(new Nothing(), liveNeighbors(0)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(1)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(2)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(3)), instanceOf(Cell.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(4)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(5)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(6)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(7)), instanceOf(Nothing.class));
		assertThat(subject.determine(new Nothing(), liveNeighbors(8)), instanceOf(Nothing.class));
	}
	
	
	private Collection<Point> liveNeighbors(int number) {
		List<Point> neighbors = new ArrayList<Point>();
		for(int i=0; i<9;i++) {
			neighbors.add(new Point(i < number ? new Cell() : new Nothing(), null));
		}
		return neighbors;
	}
	
}