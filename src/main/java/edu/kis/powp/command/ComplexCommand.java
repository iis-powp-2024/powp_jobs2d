package edu.kis.powp.command;

import java.util.ArrayList;

public class ComplexCommand implements DriverCommand {
    ArrayList<DriverCommand> commands = new ArrayList<>();

    public void addCommand(DriverCommand command) {
        this.commands.add(command);
    }

    public void removeCommand(int pos) {
        this.commands.remove(pos);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (DriverCommand command : this.commands) {
            res.append(command.toString());
        }
        return res.toString();
    }

    @Override
    public void execute() {
        for (DriverCommand command : this.commands)
            command.execute();
    }
}
