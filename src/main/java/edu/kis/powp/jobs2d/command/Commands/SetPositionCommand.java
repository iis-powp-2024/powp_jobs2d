package edu.kis.powp.jobs2d.command.Commands;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.Interfaces.DriverCommand;

public class SetPositionCommand implements DriverCommand {

    private final int x;
    private final int y;
    private final Job2dDriver driver;


    public SetPositionCommand(int x, int y, Job2dDriver driver) {
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    @Override
    public void execute() {
        driver.setPosition(x, y);
    }

}
