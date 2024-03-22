package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class FigureFactory {
    public FigureFactory() {
    }

    public static ComplexCommand getRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        List<DriverCommand> commandList = new ArrayList<>();
        commandList.add(new SetPositionCommand(x, y, driver));
        commandList.add(new OperateToCommand(x + width, y, driver));
        commandList.add(new OperateToCommand(x + width, y + height, driver));
        commandList.add(new OperateToCommand(x, y + height, driver));
        commandList.add(new OperateToCommand(x, y, driver));

        return new ComplexCommand(commandList);
    }

    public static ComplexCommand getTriangle(Job2dDriver driver, int x, int y, int width, int height)
    {
        List<DriverCommand> commandList = new ArrayList<>();
        commandList.add(new SetPositionCommand(x, y, driver));
        commandList.add(new OperateToCommand(x + width/2, y - height, driver));
        commandList.add(new OperateToCommand(x + width, y, driver));
        commandList.add(new OperateToCommand(x, y, driver));

        return new ComplexCommand(commandList);
    }

    public static ComplexCommand getHouse(Job2dDriver driver, int x, int y, int length)
    {
        List<DriverCommand> commandList = new ArrayList<>(getRectangle(driver, x, y, length, length).getCommandList());
        commandList.addAll(FigureFactory.getTriangle(driver, x, y, length, length/2).getCommandList());
        commandList.addAll(getRectangle(driver, x + length/4 - length/8, y + length/10, length/4, length/4).getCommandList());
        commandList.addAll(getRectangle(driver, x + 3 * length/4 - length/8, y + length/10, length/4, length/4).getCommandList());
        commandList.addAll(getRectangle(driver, x + length/2 - length/8, y + length - length/3, length/4, length/3).getCommandList());

        return new ComplexCommand(commandList);
    }
}
