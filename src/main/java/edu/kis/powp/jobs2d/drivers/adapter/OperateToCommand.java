package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand
{
    private int x;
    private int y;
    private Job2dDriver driver;

    public OperateToCommand(Job2dDriver driver,int x_1, int y_2)
    {
        this.driver = driver;
        this.x = x_1;
        this.y = y_2;
    }

    @Override
    public void execute()
    {
        driver.operateTo(x, y);
    }


}
