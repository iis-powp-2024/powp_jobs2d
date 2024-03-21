package edu.kis.powp.jobs2d.drivers.adapter;

import java.util.List;

public class ComplexCommand implements DriverCommand
{
    private List <DriverCommand> commands;

    ComplexCommand(List <DriverCommand> commands_1)
    {
        this.commands = commands_1;
    }

    @Override
    public void execute()
    {
        for(int i = 0; i < commands.size(); i++)
        {
            commands.get(i).execute();
        }
    }
}
