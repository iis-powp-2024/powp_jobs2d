package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CircleFactory {
    public static ComplexCommand createCircle(Job2dDriver driver, int x, int y, int radius) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x + radius, y, driver));
        for (int i = 0; i < 360; i++) {
            complexCommand.addCommand(new OperateToCommand((int) (x + radius * Math.cos(Math.toRadians(i))), (int) (y + radius * Math.sin(Math.toRadians(i))), driver));
        }
        return complexCommand;
    }
}
