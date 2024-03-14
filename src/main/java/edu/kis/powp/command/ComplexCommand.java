package edu.kis.powp.command;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand {
    ArrayList<DriverCommand> commands;

    public ComplexCommand() {
        commands = new ArrayList<>();
    }

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    public void execute() {
        for (DriverCommand command : commands) {
            command.execute();
        }
    }

}
