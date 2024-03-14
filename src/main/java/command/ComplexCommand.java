package command;

import edu.kis.powp.jobs2d.Job2dDriver;
import interfaces.DriverCommand;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    private final List<DriverCommand> commands;

    public ComplexCommand(){
        commands = new ArrayList<>();
    }

    public void addCommand(DriverCommand command){
        commands.add(command);
    }
    @Override
    public void execute(Job2dDriver driver) {
        for (DriverCommand command : commands) {
            command.execute(driver);
        }
    }
}
