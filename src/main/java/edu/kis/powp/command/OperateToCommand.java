package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    public int x, y;
    public final Job2dDriver driver;

    public OperateToCommand(Job2dDriver driver) {
        this.driver = driver;
    }
    @Override
    public void execute(){
        driver.operateTo(x,y);
    }
}
