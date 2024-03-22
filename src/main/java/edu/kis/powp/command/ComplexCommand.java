package edu.kis.powp.command;

import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commandList;

    public ComplexCommand(List<DriverCommand> commandList) {
        this.commandList = commandList;
    }

    public List<DriverCommand> getCommandList() {
        return commandList;
    }

    @Override
    public void execute() {
        commandList.forEach(DriverCommand::execute);
    }
}
