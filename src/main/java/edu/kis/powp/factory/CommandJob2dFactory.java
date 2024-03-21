package edu.kis.powp.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandJob2dFactory {
    public static ComplexCommand createRectangle(Job2dDriver driver) {
        return new ComplexCommand(new DriverCommand[] {
            new SetPositionCommand(driver, 0, 0),
            new OperateToCommand(driver, 0, 100),
            new OperateToCommand(driver, 200, 100),
            new OperateToCommand(driver, 200, 0),
            new OperateToCommand(driver, 0, 0)
        });
    }

    public static ComplexCommand createTriangle(Job2dDriver driver) {
        return new ComplexCommand(new DriverCommand[] {
            new SetPositionCommand(driver, 0, 0),
            new OperateToCommand(driver, 0, 200),
            new OperateToCommand(driver, 200, 0),
            new OperateToCommand(driver, 0, 0)
        });
    }
}
