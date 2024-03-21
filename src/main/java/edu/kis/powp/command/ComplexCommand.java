package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    List<DriverCommand> commands;

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
