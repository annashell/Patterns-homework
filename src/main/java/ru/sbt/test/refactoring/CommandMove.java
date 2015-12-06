package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class CommandMove implements Command {

    private String command;
    private Unit unit;

    public CommandMove(Unit unit, String command) {
        this.command = command;
        this.unit = unit;
    }

    public void execute() {
        if (command == "F") {
            new CommandMoveForwards(unit).execute();
        } else if (command == "T") {
            new CommandTurnClockwise(unit).execute();
        }
    }
}
