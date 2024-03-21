package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.List;

public class ComplexCommand implements DriverCommand{

    private List<DriverCommand> driverCommands;

    public ComplexCommand(List<DriverCommand> driverCommands){
        this.driverCommands = driverCommands;
    }

    public void addDriverCommand(DriverCommand driverCommand){
        this.driverCommands.add(driverCommand);
    }


    @Override
    public void execute() {
        for (DriverCommand driverCommand : driverCommands)
            driverCommand.execute();
    }

    @Override
    public void setDriver(Job2dDriver driver) {
        for (DriverCommand driverCommand : driverCommands) {
            driverCommand.setDriver(driver);
        }
    }
}
