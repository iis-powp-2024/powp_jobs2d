package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommandBuilder {
    private final List<DriverCommand> commands;

    public ComplexCommandBuilder() {
        commands = new ArrayList<>();
    }

    public ComplexCommandBuilder addCommand(DriverCommand command) {
        commands.add(command);
        return this;
    }

    public DriverCommand build() {
        ComplexCommand complexCommand = new ComplexCommand();
        commands.forEach(complexCommand::addCommand);
        return complexCommand;
    }
}
