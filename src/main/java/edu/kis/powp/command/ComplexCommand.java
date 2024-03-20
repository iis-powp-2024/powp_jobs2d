package edu.kis.powp.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commands = new ArrayList<>();

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    public void addCommand(int index, DriverCommand command) {
        commands.add(index, command);
    }

    public DriverCommand removeCommand(int index) {
        return commands.remove(index);
    }

    public DriverCommand popCommand() {
        return commands.remove(commands.size() - 1);
    }

    @Override
    public void execute() {
        commands.forEach((command) -> {
            command.execute();
        });
    }
}
