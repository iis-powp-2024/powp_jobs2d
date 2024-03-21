package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {

    final private Job2dDriver driver;
    final private int x;
    final private int y;

    public SetPositionCommand(Job2dDriver driver, int x, int y) {
        this.driver = driver;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        driver.setPosition(x, y);
    }
}
