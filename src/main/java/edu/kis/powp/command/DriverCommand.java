package edu.kis.powp.command;

import edu.kis.powp.jobs2d.drivers.DriverManager;

@FunctionalInterface
public interface DriverCommand{
    void execute(DriverManager driverManager);
}
