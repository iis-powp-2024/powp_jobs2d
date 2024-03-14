package command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.interfaces.DriverCommand;

public class SetPositionCommand implements DriverCommand {
    private int x,y;

    public void setCoordinates(int x,int y){
        this.x = x;
        this.y = y;
    }

    // set point
    @Override
    public void execute(Job2dDriver driver) {
        driver.setPosition(x,y);
    }
}
