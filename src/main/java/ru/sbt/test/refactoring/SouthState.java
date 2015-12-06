package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class SouthState implements State{

    Unit unit;

    public SouthState(Unit unit) {
        this.unit = unit;
    }

    public void moveForwards() {
        unit.setPosition(new int[] { unit.position[0], unit.position[1] - 1});
    }

    public void turnClockwise() {
        unit.setOrientation(Orientation.WEST);
        unit.setState(new WestState(unit));
    }
}
