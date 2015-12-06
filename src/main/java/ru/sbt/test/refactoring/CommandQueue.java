package ru.sbt.test.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Анна on 06.12.2015.
 */
public class CommandQueue implements Command{
    ArrayList commands = new ArrayList();

    public CommandQueue(ArrayList commands) {
        this.commands = commands;
    }

    public void execute() {
        Iterator iter = commands.iterator();
        while (iter.hasNext()){
            Command command = (Command) iter.next();
            command.execute();
        }
    }
}
