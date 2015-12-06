package ru.sbt.test.refactoring;

import java.util.ArrayList;

/**
 * Created by Анна on 06.12.2015.
 */
public class Client {

    public static void main(String[] args) {
        int[] field = new int[]{5, 5};
        Unit tractor1 = new Tractor(new int[]{0, 0}, field, Orientation.NORTH);
        Unit tractor2 = new Tractor(new int[]{1, 0}, field, Orientation.EAST);
        Unit soldier = new Soldier(new int[]{2, 0}, field, Orientation.NORTH, 10);

        ArrayList arr = new ArrayList();
        arr.add(new CommandMoveForwards(tractor1));
        arr.add(new CommandTurnClockwise(tractor2));
        arr.add(new CommandKnightMove(soldier));
        arr.add(new CommandShoot((Soldier) soldier, (Soldier) soldier));

        CommandQueue queue = new CommandQueue(arr);
        queue.execute();
    }

    private static class Soldier extends Unit {
        private int ammo;

        public Soldier(int[] position, int[] field, Orientation orientation, int ammo) {
            super(position, field, orientation);
            this.ammo = ammo;
        }

        public int getAmmo() {
            return ammo;
        }

        public void decreaseAmmo() {
            ammo = ammo - 1;
        }
    }

    private static class CommandShoot implements Command {
        private Soldier soldierActor;
        private Soldier victim;

        public CommandShoot(Soldier soldierActor, Soldier victim) {
            this.soldierActor = soldierActor;
            this.victim = victim;
        }

        public void execute() {
            if (soldierActor.getAmmo() > 0) {
                System.out.println("Soldier at position " + victim.getPositionX() + ":" + victim.getPositionY() + " shoots at position " + victim.getPositionX() + ":" + victim.getPositionY());
                System.out.println("AAAAAA!!! at position " + victim.getPositionX() + ":" + victim.getPositionY());
            } else {
                System.out.println("I can't shoot");
            }
            soldierActor.decreaseAmmo();
            System.out.println("Soldier at position " + victim.getPositionX() + ":" + victim.getPositionY() + " has " + soldierActor.getAmmo() + " bullets left");
        }

    }

    private static class CommandKnightMove implements Command {

        private Unit unit;

        public CommandKnightMove(Unit unit) {
            this.unit = unit;
        }

        public void execute() {
            ArrayList knightsMoveQueue = new ArrayList();
            knightsMoveQueue.add(new CommandMove(unit, "F"));
            knightsMoveQueue.add(new CommandMove(unit, "F"));
            knightsMoveQueue.add(new CommandMove(unit, "T"));
            knightsMoveQueue.add(new CommandMove(unit, "F"));
            CommandQueue knightsMove = new CommandQueue(knightsMoveQueue);
            knightsMove.execute();
        }
    }

}
