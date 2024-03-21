package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetToPositionCommand implements DriverCommand{
    final private int x;
    final private int y;
    final private Job2dDriver driver;

    public SetToPositionCommand(int x, int y, Job2dDriver driver) {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    @Override
    public void excecute() {
        driver.setPosition(x, y);
    }
}
