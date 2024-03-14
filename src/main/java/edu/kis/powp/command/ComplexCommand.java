package edu.kis.powp.command;


import edu.kis.powp.jobs2d.drivers.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private final List<DriverCommand> commands = new ArrayList<>();

    ComplexCommand() {}

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    @Override
    public void execute(DriverManager driverManager) {
        commands.forEach(command -> command.execute(driverManager));
    }
}
