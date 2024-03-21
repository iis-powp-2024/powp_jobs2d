package command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ShapeFactory {

    public static ComplexCommand createCircle(int startX, int startY, int radius, Job2dDriver driver){
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(startX + radius, startY, driver));
        for (int i = 0; i < 360; i++) {
            command.addCommand(new OperateToCommand((int) (startX + radius * Math.cos(Math.toRadians(i))), (int) (startY + radius * Math.sin(Math.toRadians(i))), driver));
        }
        return command;

    }

    public static ComplexCommand createRectangle(int startX, int startY, int width, int height, Job2dDriver driver){
        ComplexCommand command = new ComplexCommand();
        command.addCommand(new SetPositionCommand(startX, startY, driver));
        command.addCommand(new OperateToCommand(startX + width, startY, driver));
        command.addCommand(new OperateToCommand(startX + width, startY + height, driver));
        command.addCommand(new OperateToCommand(startX, startY + height, driver));
        command.addCommand(new OperateToCommand(startX, startY, driver));
        return command;
    }


}
