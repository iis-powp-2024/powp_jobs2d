package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class SetPositionCommand implements DriverCommand {

    private int x;
    private int y;

    public SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute(DriverManager driverManager) {
        driverManager.getCurrentDriver().setPosition(x, y);
    }
}
