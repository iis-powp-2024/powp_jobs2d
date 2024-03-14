package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {

    private int x;
    private int y;

    public SetPositionCommand(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    @Override
    public void execute(Job2dDriver driver){
        driver.setPosition(x, y);
    }
}
