package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandFactory {
    public static ComplexCommand createRectangle(int x, int y, int width, int height, Job2dDriver driver){
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new OperateToCommand(driver, x + width, y));
        complexCommand.addCommand(new OperateToCommand(driver, x + width, y + height));
        complexCommand.addCommand(new OperateToCommand(driver, x, y + height));
        complexCommand.addCommand(new OperateToCommand(driver, x, y));
        return complexCommand;
    }
}
