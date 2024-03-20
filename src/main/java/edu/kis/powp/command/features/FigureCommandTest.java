package edu.kis.powp.command.features;

import edu.kis.powp.command.command.ComplexCommand;
import edu.kis.powp.command.command.OperateToCommand;
import edu.kis.powp.command.command.SetPositionCommand;
import edu.kis.powp.command.factory.CircleFactory;
import edu.kis.powp.command.factory.CommandFactory;
import edu.kis.powp.command.factory.RectangleFactory;
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

    public static void rectangleTest(Job2dDriver driver){
        CommandFactory factory = new RectangleFactory();
        factory.create(driver).execute();
    }

    public static void circleTest(Job2dDriver driver){
        CommandFactory factory = new CircleFactory();
        factory.create(driver).execute();
    }
}
