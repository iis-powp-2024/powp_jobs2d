package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.function.Consumer;

public class ScriptToCommand implements Job2dDriver {

    private final ComplexCommand complexCommand = new ComplexCommand();

    public ScriptToCommand(Consumer<Job2dDriver> figure) {
        figure.accept(this);
    }

    @Override
    public void setPosition(int i, int i1) {
        complexCommand.addCommand(new SetPositionCommand(i, i1));
    }

    @Override
    public void operateTo(int i, int i1) {
        complexCommand.addCommand(new OperateToCommand(i, i1));
    }

    public ComplexCommand getComplexCommand() {
        return complexCommand;
    }
}
