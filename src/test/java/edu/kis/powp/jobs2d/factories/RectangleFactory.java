package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class RectangleFactory {

    private ComplexCommand rectangle;

    public ComplexCommand getRectangle() {
        return rectangle;
    }

    public RectangleFactory(Job2dDriver driver) {
        this.rectangle = new ComplexCommand();
        this.rectangle.addCommand(new SetPositionCommand(0, 0, driver));
        this.rectangle.addCommand(new OperateToCommand(100, 0, driver));
        this.rectangle.addCommand(new OperateToCommand(100, 100, driver));
        this.rectangle.addCommand(new OperateToCommand(0, 100, driver));
        this.rectangle.addCommand(new OperateToCommand(0, 0, driver));
    }
}
