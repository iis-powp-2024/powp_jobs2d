package edu.kis.powp.jobs2d.command.Commands;

import edu.kis.powp.jobs2d.command.Interfaces.DriverCommand;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {

    private final List<DriverCommand> commands;


    public ComplexCommand() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(DriverCommand newCommand) {
        commands.add(newCommand);
    }

    @Override
    public void execute() {
        commands.forEach(DriverCommand::execute);
    }

}
