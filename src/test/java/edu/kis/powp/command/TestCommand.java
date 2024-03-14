package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class TestCommand {

    static public void executeTest(Job2dDriver driver) {
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(driver, 0, 0));
        command.addCommand(new OperateToCommand(driver, 15, 0));
        command.addCommand(new OperateToCommand(driver, 15, 15));
        command.addCommand(new OperateToCommand(driver, 0, 15));
        command.addCommand(new OperateToCommand(driver, 0, 0));
        command.execute();
    }
}
