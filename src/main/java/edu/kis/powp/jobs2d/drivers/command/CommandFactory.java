package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.DriverCommand;
import edu.kis.powp.jobs2d.drivers.OperateToCommand;
import edu.kis.powp.jobs2d.drivers.SetPositionCommand;

public class CommandFactory {
    public static DriverCommand makeSquare(Job2dDriver driver, int x, int y, int len) {
        ComplexCommand square = new ComplexCommand();
        square.addCommand(new SetPositionCommand(driver, x, y));
        square.addCommand(new OperateToCommand(driver, x + len, y));
        square.addCommand(new OperateToCommand(driver, x + len, y + len));
        square.addCommand(new OperateToCommand(driver, x, y + len));
        square.addCommand(new OperateToCommand(driver, x, y));
        return square;
    }
}