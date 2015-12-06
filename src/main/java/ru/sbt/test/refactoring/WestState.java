package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class WestState implements State {

    Unit unit;

    public WestState(Unit unit) {
        this.unit = unit;
    }

    public void moveForwards() {
        unit.setPosition(new int[] { unit.position[0]-1, unit.position[1]});
    }

    public void turnClockwise() {
        unit.setOrientation(Orientation.NORTH);
        unit.setState(new NorthState(unit));
    }
}
