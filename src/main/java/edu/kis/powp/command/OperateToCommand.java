package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    public int x, y;
    public final Job2dDriver driver;

    public OperateToCommand(Job2dDriver driver) {
        this.driver = driver;
    }

    public OperateToCommand(int x, int y, Job2dDriver driver) {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    public void setNewPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void execute(){
        this.driver.operateTo(x,y);
    }
}
