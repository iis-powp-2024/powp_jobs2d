package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class DiamondFactory {
    public ComplexCommand getDiamond() {
        return diamond;
    }

    private ComplexCommand diamond;

    public DiamondFactory(Job2dDriver driver) {
        this.diamond = new ComplexCommand();
        this.diamond.addCommand(new SetPositionCommand(0, 100, driver));
        this.diamond.addCommand(new OperateToCommand(50, 0, driver));
        this.diamond.addCommand(new OperateToCommand(0, -100, driver));
        this.diamond.addCommand(new OperateToCommand(-50, 0, driver));
        this.diamond.addCommand(new OperateToCommand(0, 100, driver));
    }
}
