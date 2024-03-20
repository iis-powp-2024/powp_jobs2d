package edu.kis.powp.command.factory;

import edu.kis.powp.command.command.DriverCommand;
import edu.kis.powp.command.command.ComplexCommand;
import edu.kis.powp.command.command.OperateToCommand;
import edu.kis.powp.command.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class CircleFactory extends CommandFactory {
    @Override
    protected DriverCommand createCommand(Job2dDriver driver) {
        int radius = 50;
        int centerX = 0;
        int centerY = 0;
        int steps = 360;

        ComplexCommand command = new ComplexCommand();

        command.addCommand(new SetPositionCommand(centerX + radius, centerY, driver));

        for (int i = 0; i < steps; i++) {
            double angle = Math.toRadians(i);
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            command.addCommand(new OperateToCommand(x, y, driver));
        }

        command.addCommand(new SetPositionCommand(centerX + radius, centerY, driver));

        return command;
    }
}
