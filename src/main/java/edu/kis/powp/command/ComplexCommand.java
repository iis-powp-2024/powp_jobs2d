package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> commands = new ArrayList<>();

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    public void addCommand(int index, DriverCommand command) {
        commands.add(index, command);
    }

    public DriverCommand removeCommand(int index) {
        return commands.remove(index);
    }

    public DriverCommand popCommand() {
        return commands.remove(commands.size() - 1);
    }

    @Override
    public void execute() {
        commands.forEach((command) -> {
            command.execute();
        });
    }

    public static ComplexCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.addCommand(new SetPositionCommand(x, y, driver));

        complexCommand.addCommand(new OperateToCommand(x + width, y, driver));
        complexCommand.addCommand(new OperateToCommand(x + width, y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x, y + height, driver));
        complexCommand.addCommand(new OperateToCommand(x, y, driver));
        return complexCommand;
    }

    public static ComplexCommand createCircle(Job2dDriver driver, int x, int y, int radius) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x + radius, y, driver));

        for (int angle = 0; angle < 360; angle++) {
            double radians = Math.toRadians(angle);
            int nextX = (int) (x + radius * Math.cos(radians));
            int nextY = (int) (y + radius * Math.sin(radians));
            complexCommand.addCommand(new OperateToCommand(nextX, nextY, driver));
        }

        return complexCommand;
    }
}
