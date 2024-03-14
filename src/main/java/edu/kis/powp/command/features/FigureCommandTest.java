package edu.kis.powp.command.features;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FigureCommandTest {
    FigureCommandTest(){}

    public static void figureTest(Job2dDriver driver){
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(100, 100, driver));
        complexCommand.addCommand(new OperateToCommand(150, 100, driver));
        complexCommand.addCommand(new OperateToCommand(150, 150, driver));
        complexCommand.addCommand(new OperateToCommand(100, 150, driver));
        complexCommand.addCommand(new OperateToCommand(100, 100, driver));
        complexCommand.execute();
    }
}
