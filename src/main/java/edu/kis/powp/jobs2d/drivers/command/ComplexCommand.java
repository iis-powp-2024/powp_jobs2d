package edu.kis.powp.jobs2d.drivers.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private final List<DriverCommand> commandList;

    public ComplexCommand() {
        this.commandList = new ArrayList<>();
    }

    public void addCommand(DriverCommand driverCommand) {
        commandList.add(driverCommand);
    }

    @Override
    public void execute() {
        commandList.forEach(DriverCommand::execute);
    }
}
