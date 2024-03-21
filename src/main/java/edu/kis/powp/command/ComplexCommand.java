package edu.kis.powp.command;

public class ComplexCommand implements DriverCommand{
    private DriverCommand[] commandList;

    public ComplexCommand(DriverCommand[] commands) {
        this.commandList = commands;
    }

    @Override
    public void excecute() {
        for (DriverCommand command : commandList) {
            command.excecute();
        }
    }


}
