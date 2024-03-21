package edu.kis.powp.command;

public class OperateToCommand implements DriverCommand{
    private int x;
    private int y;

    public OperateToCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {

    }
}
