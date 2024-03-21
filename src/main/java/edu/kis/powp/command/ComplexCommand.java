package edu.kis.powp.command;

import java.util.List;

public class ComplexCommand implements DriverCommand {
    final private List<DriverCommand> driverCommands;

    public ComplexCommand(List<DriverCommand> driverCommands) {
        this.driverCommands = driverCommands;
    }

    public void execute() {
        driverCommands.forEach(DriverCommand::execute);
    }
}
