package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.commands.ComplexCommand;
import edu.kis.powp.jobs2d.commands.OperateToCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;

public class DiamondFactory {
    private final ComplexCommand diamond;

    public DiamondFactory(Job2dDriver driver) {
        diamond = new ComplexCommand();
        diamond.addCommand(new SetPositionCommand(0, 100, driver));
        diamond.addCommand(new OperateToCommand(50, 0, driver));
        diamond.addCommand(new OperateToCommand(0, -100, driver));
        diamond.addCommand(new OperateToCommand(-50, 0, driver));
        diamond.addCommand(new OperateToCommand(0, 100, driver));
    }

    public ComplexCommand getDiamond() {
        return diamond;
    }
}