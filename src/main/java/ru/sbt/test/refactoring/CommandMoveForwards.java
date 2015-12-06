package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class CommandMoveForwards implements Command{

    private Unit unit;

    public CommandMoveForwards (Unit unit) {
        this.unit = unit;
    }

    public void execute() {
        unit.state.moveForwards();
        if (unit.position[0] > unit.field[0] || unit.position[1] > unit.field[1]) {
            throw new UnitInDitchException();
        }
        System.out.println("Unit moved to position " +  + unit.getPositionX() + ":" + unit.getPositionY());
    }
}
