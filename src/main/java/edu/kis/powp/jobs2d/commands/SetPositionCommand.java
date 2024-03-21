package edu.kis.powp.jobs2d.commands;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {

    private final int x;
    private final int y;
    private final Job2dDriver driver;

    public SetPositionCommand(int posX, int posY, Job2dDriver driver) {
        this.x = posX;
        this.y = posY;
        this.driver = driver;
    }

    @Override
    public void execute() {
        driver.setPosition(getX(), getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
