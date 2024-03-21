package edu.kis.powp.command.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public static DriverCommand getSquare(Job2dDriver driver, Integer size) {
        return new ComplexCommand(new DriverCommand[]{
                new SetPositionCommand(driver, 0, 0),
                new OperateToCommand(driver, 0, size),
                new OperateToCommand(driver, size, size),
                new OperateToCommand(driver, size, 0),
                new OperateToCommand(driver, 0, 0)
        });
    }

    public static DriverCommand getRectangle(Job2dDriver driver, Integer width, Integer height) {
        return new ComplexCommand(new DriverCommand[]{
                new SetPositionCommand(driver, 0, 0),
                new OperateToCommand(driver, 0, height),
                new OperateToCommand(driver, width, height),
                new OperateToCommand(driver, width, 0),
                new OperateToCommand(driver, 0, 0)
        });
    }
}
