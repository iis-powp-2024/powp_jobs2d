package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {

    final private Job2dDriver driver;
    final private int x;
    final private int y;

    public OperateToCommand(Job2dDriver driver, int x, int y) {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        driver.operateTo(x, y);
    }
}
