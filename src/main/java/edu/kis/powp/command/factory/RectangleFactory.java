package edu.kis.powp.command.factory;

import edu.kis.powp.command.command.DriverCommand;
import edu.kis.powp.command.command.ComplexCommand;
import edu.kis.powp.command.command.OperateToCommand;
import edu.kis.powp.command.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleFactory extends CommandFactory {

    @Override
    protected DriverCommand createCommand(Job2dDriver driver) {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(-120, -120, driver));
        command.addCommand(new OperateToCommand(120, -120, driver));
        command.addCommand(new OperateToCommand(120, 120, driver));
        command.addCommand(new OperateToCommand(-120, 120, driver));
        command.addCommand(new OperateToCommand(-120, -120, driver));
        return command;
    }
}
