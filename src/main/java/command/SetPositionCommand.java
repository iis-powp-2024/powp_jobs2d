package command;

import edu.kis.powp.jobs2d.Job2dDriver;
import interfaces.DriverCommand;

public class SetPositionCommand implements DriverCommand {
    private int x,y;
    private final Job2dDriver driver;

    SetPositionCommand(int x, int y, Job2dDriver driver){
        this.x = x;
        this.y = y;
        this.driver = driver;
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }


    // go to next point
    @Override
    public void execute() {
        this.driver.setPosition(x,y);
    }
}
