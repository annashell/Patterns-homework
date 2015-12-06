package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class NorthState implements State{

    Unit unit;

    public NorthState(Unit unit) {
        this.unit = unit;
    }

    public void moveForwards() {
        unit.setPosition(new int[] { unit.position[0], unit.position[1] + 1 });
    }

    public void turnClockwise() {
        unit.setOrientation(Orientation.EAST);
        unit.setState(new EastState(unit));
    }
}
