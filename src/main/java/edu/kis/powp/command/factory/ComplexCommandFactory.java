package edu.kis.powp.command.factory;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;

public class ComplexCommandFactory {

    public void drawSquare(Job2dDriver driver) {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(driver, -50, -50));
        commands.add(new OperateToCommand(driver, 50, -50));
        commands.add(new OperateToCommand(driver, 50, 50));
        commands.add(new OperateToCommand(driver, -50, 50));
        commands.add(new OperateToCommand(driver, -50, -50));
        new ComplexCommand(commands).execute();
    }

    public void drawTriangle(Job2dDriver driver) {
        ArrayList<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(driver, 0, 0));
        commands.add(new OperateToCommand(driver, 50, 0));
        commands.add(new OperateToCommand(driver, 25, 50));
        commands.add(new OperateToCommand(driver, 0, 0));
        new ComplexCommand(commands).execute();
    }
}
