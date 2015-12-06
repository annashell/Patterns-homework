package ru.sbt.test.refactoring;

/**
 * Created by Анна on 06.12.2015.
 */
public class Unit {

    int[] position;
    Orientation orientation;
    int[] field;
    State state;

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Unit(int[] position, int[] field, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        this.field = field;
        if (orientation == Orientation.NORTH) {
            state = new NorthState(this);
        } else if (orientation == Orientation.SOUTH) {
            state = new SouthState(this);
        } else if (orientation == Orientation.WEST) {
            state = new WestState(this);
        } else if (orientation == Orientation.EAST) {
            state = new EastState(this);
        }
    }


    // метод оставлен, чтобы проходились исходные тесты
    public void move(String command){
        Command moveCommand = new CommandMove(this, command);
        moveCommand.execute();
    }

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
