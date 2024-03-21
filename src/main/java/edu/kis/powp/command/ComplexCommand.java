package edu.kis.powp.command;

import java.util.List;

/**
 * Complex command class.
 * In command package, we use command and composite design patterns.
 */

public class ComplexCommand implements DriverCommand {
    final private List<DriverCommand> driverCommands;

    public ComplexCommand(List<DriverCommand> driverCommands) {
        this.driverCommands = driverCommands;
    }

    public void execute() {
        driverCommands.forEach(DriverCommand::execute);
    }
}
