package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class TestCommand {

    static public void executeTest(Job2dDriver driver) {
        SetPositionCommand command1 = new SetPositionCommand(driver, 0, 0);
        OperateToCommand command2 = new OperateToCommand(driver, 15, 0);
        OperateToCommand command3 = new OperateToCommand(driver, 15, 15);
        OperateToCommand command4 = new OperateToCommand(driver, 0, 15);
        OperateToCommand command5 = new OperateToCommand(driver, 0, 0);
        command1.execute();
        command2.execute();
        command3.execute();
        command4.execute();
        command5.execute();
    }
}
