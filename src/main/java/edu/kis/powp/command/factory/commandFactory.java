package edu.kis.powp.command.factory;

import edu.kis.powp.command.drivers.DriverCommand;

public abstract class commandFactory {
    public DriverCommand create(){
        DriverCommand command = createCommand();
        return command;
    }

    protected abstract DriverCommand createCommand();
}
