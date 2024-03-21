package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexFactoryCommand {
    public static DriverCommand rectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand rectangle = new ComplexCommand();

        rectangle.addCommand(new SetPositionCommand(x, y, driver));
        rectangle.addCommand(new OperateToCommand(x+width, y, driver));
        rectangle.addCommand(new OperateToCommand(x+width, y+height, driver));
        rectangle.addCommand(new OperateToCommand(x, y+height, driver));
        rectangle.addCommand(new OperateToCommand(x, y, driver));

        return rectangle;
    }

    public static DriverCommand circle(Job2dDriver driver, int centerX, int centerY, int radius) {
        ComplexCommand circle = new ComplexCommand();

        int segments = 360;
        double angleStep = 2 * Math.PI / segments;

        for(int i = 0; i <= segments; i++) {
            double angle = i * angleStep;
            int x = (int)(centerX + radius * Math.cos(angle));
            int y = (int)(centerY + radius * Math.sin(angle));

            if(i == 0) {
                circle.addCommand(new SetPositionCommand(x, y, driver));
            } else {
                circle.addCommand(new OperateToCommand(x, y, driver));
            }
        }

        return circle;
    }
}
