package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class RectangleFactory {

    private final ComplexCommand rectangle;

    public RectangleFactory(Job2dDriver driver) {
        rectangle = new ComplexCommand();
        rectangle.addCommand(new SetPositionCommand(0, 0, driver));
        rectangle.addCommand(new OperateToCommand(100, 0, driver));
        rectangle.addCommand(new OperateToCommand(100, 100, driver));
        rectangle.addCommand(new OperateToCommand(0, 100, driver));
        rectangle.addCommand(new OperateToCommand(0, 0, driver));
    }

    public ComplexCommand getRectangle() {
        return rectangle;
    }
}