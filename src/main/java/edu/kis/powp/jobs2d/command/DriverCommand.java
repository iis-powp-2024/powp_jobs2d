package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public interface DriverCommand {
    public void execute();
    public void setDriver(Job2dDriver driver);
}
