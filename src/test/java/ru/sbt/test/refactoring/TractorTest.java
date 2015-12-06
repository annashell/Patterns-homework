package ru.sbt.test.refactoring;

import junit.framework.TestCase;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

	int[] field = new int[]{5, 5};

	public void testShouldMoveForward(){
		Tractor tractor = new Tractor(new int[]{0, 0}, field, Orientation.NORTH);
		tractor.move("F");
		assertEquals(0, tractor.getPositionX());
		assertEquals(1, tractor.getPositionY());
	}

	public void testShouldTurn(){
		Tractor tractor = new Tractor(new int[]{0, 0}, field, Orientation.NORTH);
		tractor.move("T");
		assertEquals(Orientation.EAST, tractor.getOrientation());
		tractor.move("T");
		assertEquals(Orientation.SOUTH, tractor.getOrientation());
		tractor.move("T");
		assertEquals(Orientation.WEST, tractor.getOrientation());
		tractor.move("T");
		assertEquals(Orientation.NORTH, tractor.getOrientation());
	}

	public void testShouldTurnAndMoveInTheRightDirection(){
		Tractor tractor = new Tractor(new int[]{0, 0}, field, Orientation.NORTH);
		tractor.move("T");
		tractor.move("F");		
		assertEquals(1, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());
		tractor.move("T");
		tractor.move("F");		
		assertEquals(1, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move("T");
		tractor.move("F");		
		assertEquals(0, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move("T");
		tractor.move("F");		
		assertEquals(0, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());		
	}
	
	public void testShouldThrowExceptionIfFallsOffPlateau(){
		Tractor tractor = new Tractor(new int[]{0, 0}, field, Orientation.NORTH);
		tractor.move("F");
		tractor.move("F");
		tractor.move("F");
		tractor.move("F");
		tractor.move("F");
		try{
			tractor.move("F");
			fail("Tractor was expected to fall off the plateau");
		}catch(UnitInDitchException expected){
		}
	}
}
