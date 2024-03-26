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

    public static DriverCommand makeTriangle(Job2dDriver driver, int x1, int y1, int x2, int y2, int x3, int y3) {
        ComplexCommand triangle = new ComplexCommand();
        triangle.addCommand(new SetPositionCommand(driver, x1, y1));
        triangle.addCommand(new OperateToCommand(driver, x2, y2));
        triangle.addCommand(new OperateToCommand(driver, x3, y3));
        triangle.addCommand(new OperateToCommand(driver, x1, y1));
        return triangle;
    }
}