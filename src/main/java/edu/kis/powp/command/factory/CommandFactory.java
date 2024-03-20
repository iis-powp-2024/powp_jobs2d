package edu.kis.powp.command.factory;

import edu.kis.powp.command.command.DriverCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public abstract class CommandFactory {
    public DriverCommand create(Job2dDriver driver){
        DriverCommand command = createCommand(driver);
        return command;
    }

    protected abstract DriverCommand createCommand(Job2dDriver driver);
}
