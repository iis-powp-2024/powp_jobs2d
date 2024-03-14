package edu.kis.powp.command;

public class CommandFactory {

    public static ComplexCommand createRectangle(int x, int y, int width, int height){
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x, y));
        complexCommand.addCommand(new OperateToCommand(x + width, y));
        complexCommand.addCommand(new OperateToCommand(x + width, y + height));
        complexCommand.addCommand(new OperateToCommand( x, y + height));
        complexCommand.addCommand(new OperateToCommand( x, y));
        return complexCommand;
    }

    public static ComplexCommand createCircle(int x, int y, int radius) {

        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(x + radius, y));
        for (int j = 0; j < 360; j++) {
            complexCommand.addCommand(new OperateToCommand((int) (radius * Math.cos(Math.toRadians(j)) + x), (int) (radius * Math.sin(Math.toRadians(j)) + y)));
        }
        complexCommand.addCommand(new SetPositionCommand(x, y));
        return complexCommand;
    }
}
