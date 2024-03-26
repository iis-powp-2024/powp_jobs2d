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

    public static DriverCommand makeCircle(Job2dDriver driver, int centerX, int centerY, int radius) {
        ComplexCommand circle = new ComplexCommand();

        int startX = (int) (centerX + radius * Math.cos(0));
        int startY = (int) (centerY + radius * Math.sin(0));
        circle.addCommand(new SetPositionCommand(driver, startX, startY));

        int numSegments = 100;
        double angleIncrement = 2 * Math.PI / numSegments;
        for (int i = 1; i <= numSegments; i++) {
            double angle = angleIncrement * i;
            int nextX = (int) (centerX + radius * Math.cos(angle));
            int nextY = (int) (centerY + radius * Math.sin(angle));
            circle.addCommand(new OperateToCommand(driver, nextX, nextY));
        }

        circle.addCommand(new OperateToCommand(driver, startX, startY));

        return circle;
    }
}