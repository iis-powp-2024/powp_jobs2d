package edu.kis.powp.command;

public class SetPositionCommand implements DriverCommand{
    private int x;
    private int y;

    public SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {

    }
}
