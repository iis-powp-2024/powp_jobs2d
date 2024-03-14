package edu.kis.powp.command.features;

import edu.kis.powp.command.drivers.DriverCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;
    private final Job2dDriver driver;

    SetPositionCommand(int x, int y, Job2dDriver driver){
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public void execute(){
        driver.setPosition(this.x, this.y);
    }
}
