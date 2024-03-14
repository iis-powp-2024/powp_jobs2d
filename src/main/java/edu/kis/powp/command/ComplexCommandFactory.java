package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class ComplexCommandFactory {

    public static DriverCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand rectangle = new ComplexCommand();
        rectangle.addCommand(new SetPositionCommand(x, y, driver));
        rectangle.addCommand(new OperateToCommand(x + width, y, driver));
        rectangle.addCommand(new OperateToCommand(x + width, y + height, driver));
        rectangle.addCommand(new OperateToCommand(x, y + height, driver));
        rectangle.addCommand(new OperateToCommand(x, y, driver));
        return rectangle;
    }
    public static DriverCommand createTriangle(Job2dDriver driver, int x, int y, int length){
        ComplexCommand triangle = new ComplexCommand();
        int height = (int) (Math.sqrt(3.0) / 2 * length);
        triangle.addCommand(new SetPositionCommand(x, y, driver));
        triangle.addCommand(new OperateToCommand(x+length, y, driver));
        triangle.addCommand(new OperateToCommand(x+(length/2), y-height, driver));
        triangle.addCommand(new OperateToCommand(x, y, driver));

        return triangle;
    }
}
