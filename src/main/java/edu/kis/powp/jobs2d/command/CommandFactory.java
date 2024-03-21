package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public static DriverCommand makeSquare(Job2dDriver driver, int x, int y, int len) {
        ComplexCommand square = new ComplexCommand();
        square.addDriverCommandList(new SetPositionCommand(driver, x, y));
        square.addDriverCommandList(new OperateToCommand(driver, x + len, y));
        square.addDriverCommandList(new OperateToCommand(driver, x + len, y + len));
        square.addDriverCommandList(new OperateToCommand(driver, x, y + len));
        square.addDriverCommandList(new OperateToCommand(driver, x, y));
        return square;
    }
}
