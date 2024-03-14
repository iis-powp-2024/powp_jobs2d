package edu.kis.powp.command;


import java.util.ArrayList;
import java.util.List;

public class ComplexCommand {
    private List<DriverCommand> commands = new ArrayList<>();

    ComplexCommand() {}
    ComplexCommand(List<DriverCommand> commands) {
        this.commands = commands;
    }

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    public void executeAll() {
        commands.forEach(DriverCommand::execute);
    }
}
