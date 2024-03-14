package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {

    private int x, y;

    public OperateToCommand(int posX, int posY) {
        super();
        this.x = posX;
        this.y = posY;
    }

    @Override
    public void execute(Job2dDriver driver) {
        driver.operateTo(x, y);
    }
}
