package edu.kis.powp.jobs2d.drivers.DriverCommands;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{

    private List<DriverCommand> driverCommandList = new ArrayList<>();

    public ComplexCommand(){};

    public void addCommand(DriverCommand command)
    {
        driverCommandList.add(command);
    }

    public void execute()
    {
        for(DriverCommand command : driverCommandList)
            command.execute();
    }
}
