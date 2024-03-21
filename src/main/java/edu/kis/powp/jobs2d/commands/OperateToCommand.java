package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {

    private final Job2dDriver driver;
    private int x;
    private int y;

    public OperateToCommand(int posX, int posY, Job2dDriver driver) {
        this.x = posX;
        this.y = posY;
        this.driver = driver;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        driver.operateTo(x, y);
    }
}
