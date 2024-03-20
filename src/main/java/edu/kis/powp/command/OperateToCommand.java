package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {

    private int x, y;
    private Job2dDriver driver;

    public OperateToCommand(int posX, int posY, Job2dDriver driver) {
        this.x = posX;
        this.y = posY;
        this.driver = driver;
    }

    @Override
    public void execute() {
        this.driver.operateTo(x, y);
    }
}
