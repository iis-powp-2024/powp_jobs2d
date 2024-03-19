package edu.kis.powp.jobs2d.command;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDrawerAdapter;

import javax.swing.*;

public class ComplexCommandTest {
    public static ComplexCommand setupSquareFactory() {
        ComplexCommand commands = new ComplexCommand();
        DriverDrawerAdapter basicAdapter = new DriverDrawerAdapter();
        commands.addCommand(new SetPositionCommand(0, 0, basicAdapter));
        commands.addCommand(new OperateToCommand(100, 0, basicAdapter));
        commands.addCommand(new OperateToCommand(100, 100, basicAdapter));
        commands.addCommand(new OperateToCommand(0, 100, basicAdapter));
        commands.addCommand(new OperateToCommand(0, 0, basicAdapter));
        return commands;
    }

    public static ComplexCommand setupRhombusFactory() {
        ComplexCommand commands = new ComplexCommand();
        DriverDrawerAdapter basicAdapter = new DriverDrawerAdapter();
        commands.addCommand(new SetPositionCommand(0, 0, basicAdapter));
        for (int i = 0; i<50; i++)
            commands.addCommand(new OperateToCommand(i*2, i, basicAdapter));
        for (int i = 0; i<50; i++)
            commands.addCommand(new OperateToCommand(100 + i*2, 50 - i, basicAdapter));
        for (int i = 0; i<50; i++)
            commands.addCommand(new OperateToCommand(200 - i*2,  -i, basicAdapter));
        for (int i = 0; i<50; i++)
            commands.addCommand(new OperateToCommand(100 - i*2,  -50 + i, basicAdapter));
        return commands;
    }
}
