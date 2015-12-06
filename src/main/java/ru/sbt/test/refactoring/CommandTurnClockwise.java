package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class CommandTurnClockwise implements Command{

    private Unit unit;

    public CommandTurnClockwise (Unit unit) {
        this.unit = unit;
    }

    public void execute() {
        unit.state.turnClockwise();
        System.out.println("Unit at position " + unit.getPositionX() + ":" + unit.getPositionY() + " changed orientation to " + unit.getOrientation());
    }

}
