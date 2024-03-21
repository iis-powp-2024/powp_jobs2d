package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.Arrays;
import java.util.List;

public class ShapeFactory {
    public static ComplexCommand rectangle(Job2dDriver driver){
        DriverCommand driverCommand1 = new SetPositionCommand(0,0);
        DriverCommand driverCommand2 = new OperateToCommand(100,0);
        DriverCommand driverCommand3 = new OperateToCommand(100,100);
        DriverCommand driverCommand4 = new OperateToCommand(0,100);
        DriverCommand driverCommand5 = new OperateToCommand(0,0);
        List<DriverCommand> driverCommands = Arrays.asList(driverCommand1,
                driverCommand2, driverCommand3, driverCommand4, driverCommand5);
        ComplexCommand complexCommand = new ComplexCommand(driverCommands);
        complexCommand.setDriver(driver);
        return complexCommand;
    }

    public static ComplexCommand triangle(Job2dDriver driver){

    }
}
