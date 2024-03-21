package edu.kis.powp.command;

import edu.kis.powp.jobs2d.drivers.adapter.DriverAdapter;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    private List<DriverCommand> commands;

    public ComplexCommand(){
        this.commands = new ArrayList<>();
    }

    public void addCommand(DriverCommand command){
        this.commands.add(command);
    }

    @Override
    public void execute() {
        for(DriverCommand command : this.commands){
            command.execute();
        }
    }
}
