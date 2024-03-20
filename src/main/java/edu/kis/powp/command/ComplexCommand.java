package edu.kis.powp.command;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand{
    private final ArrayList<DriverCommand> listOfCommands = new ArrayList<>();

    public void addCommand(DriverCommand newCommand){
        listOfCommands.add(newCommand);
    }

    @Override
    public void execute() {
        for (DriverCommand command : listOfCommands) {
            command.execute();
        }
    }
}
