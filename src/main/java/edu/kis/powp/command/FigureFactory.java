package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureFactory {

    public static DriverCommand getSquare(Job2dDriver driver) {
        return new ComplexCommandBuilder()
                .addCommand(new SetPositionCommand(driver, -100, -100))
                .addCommand(new OperateToCommand(driver, 100, -100))
                .addCommand(new OperateToCommand(driver, 100, 100))
                .addCommand(new OperateToCommand(driver, -100, 100))
                .addCommand(new OperateToCommand(driver, -100, -100))
                .build();
    }

    public static DriverCommand getTriangle(Job2dDriver driver) {
        return new ComplexCommandBuilder()
                .addCommand(new SetPositionCommand(driver, -100, -100))
                .addCommand(new OperateToCommand(driver, 100, -100))
                .addCommand(new OperateToCommand(driver, 0, 100))
                .addCommand(new OperateToCommand(driver, -100, -100))
                .build();
    }

    public static DriverCommand getRhombus(Job2dDriver driver) {
        return new ComplexCommandBuilder()
                .addCommand(new SetPositionCommand(driver, 0, -100))
                .addCommand(new OperateToCommand(driver, 200, 0))
                .addCommand(new OperateToCommand(driver, 0, 100))
                .addCommand(new OperateToCommand(driver, -200, 0))
                .addCommand(new OperateToCommand(driver, 0, -100))
                .build();
    }

    public static DriverCommand getCircle(Job2dDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(driver, 100, 0));
        for (int i = 0; i < 360; i++) {
            double rad = Math.toRadians(i);
            complexCommand.addCommand(new OperateToCommand(driver, (int) (100 * Math.cos(rad)), (int) (100 * Math.sin(rad))));
        }
        return complexCommand;
    }

    public static DriverCommand getNSidedFigure(Job2dDriver driver, int n) {
        ComplexCommand complexCommand = new ComplexCommand();
        int radius = 100;
        complexCommand.addCommand(new SetPositionCommand(driver, (int) (radius * Math.cos(0)), 0));
        for (int i = 0; i < n; i++) {
            double rad = Math.toRadians(360.0 / n * i);
            int x = (int) (radius * Math.cos(rad));
            int y = (int) (radius * Math.sin(rad));
            complexCommand.addCommand(new OperateToCommand(driver, x, y));
        }
        complexCommand.addCommand(new OperateToCommand(driver, (int) (radius * Math.cos(0)), 0));
        return complexCommand;
    }
}
