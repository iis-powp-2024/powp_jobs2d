package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleFactory {
    public static ComplexCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x, y, driver));
        complexCommand.addCommand(new OperateToCommand(x + width, y, driver));
        complexCommand.addCommand(new OperateToCommand(x + width, y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x, y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x, y, driver));
        return complexCommand;
    }
}
