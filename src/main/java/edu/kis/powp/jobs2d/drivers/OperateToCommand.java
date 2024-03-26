package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    private final int x;
    private final int y;
    private final Job2dDriver driver;

    public OperateToCommand(Job2dDriver driver, int x, int y) {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }
    @Override
    public void execute(Job2dDriver driver){
        driver.operateTo(x, y);
    }
}
