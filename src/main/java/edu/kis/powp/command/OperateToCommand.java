package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand{

    private int x;
    private int y;
    private final Job2dDriver driver;

    public Job2dDriver getDriver() {
        return driver;
    }

    public OperateToCommand(Job2dDriver driver, int x, int y) {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        getDriver().operateTo(x, y);
    }
}
