package edu.kis.powp.command.features;

import edu.kis.powp.command.drivers.DriverCommand;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private List<DriverCommand> driverCommandList;

    public ComplexCommand(){
        driverCommandList = new ArrayList<>();
    }

    public void addCommand(DriverCommand command){
        driverCommandList.add(command);
    }

    @Override
    public void execute(){
        for(DriverCommand command : driverCommandList){
            command.execute();
        }
    }
}
