package edu.kis.powp.jobs2d.drivers.DriverCommands;

import edu.kis.powp.jobs2d.Job2dDriver;
import java.lang.Math;

public class CommandFactory {

    public ComplexCommand getSquare(Job2dDriver driver, int x, int y, int size)
    {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(x, y-size/2, driver));
        command.addCommand(new OperateToCommand(x-size/2, y-size/2, driver));
        command.addCommand(new OperateToCommand(x-size/2, y+size/2, driver));
        command.addCommand(new OperateToCommand(x+size/2, y+size/2, driver));
        command.addCommand(new OperateToCommand(x+size/2, y-size/2, driver));
        command.addCommand(new OperateToCommand(x, y-size/2, driver));

        return command;
    }

    public ComplexCommand getTriangle(Job2dDriver driver, int x, int y, int size)
    {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(x, y+size/2, driver));
        command.addCommand(new OperateToCommand(x-size/2, y+size/2, driver));
        command.addCommand(new OperateToCommand(x, y-size/2, driver));
        command.addCommand(new OperateToCommand(x+size/2, y+size/2, driver));
        command.addCommand(new OperateToCommand(x, y+size/2, driver));

        return command;
    }

    public ComplexCommand getCircle(Job2dDriver driver, int x, int y, int radius)
    {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(x-radius, y, driver));
        for(int i=-radius; i<=radius; i++)
            command.addCommand(new OperateToCommand(x+i, (int) (y+Math.sqrt(radius*radius-i*i)), driver));
        command.addCommand(new SetPositionCommand(x-radius, y, driver));
        for(int i=-radius; i<=radius; i++)
            command.addCommand(new OperateToCommand(x+i, (int) (y-Math.sqrt(radius*radius-i*i)), driver));


        return command;
    }
}
