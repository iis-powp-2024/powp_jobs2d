package edu.kis.powp.jobs2d.drivers.command;


import edu.kis.powp.jobs2d.Job2dDriver;
public class CommandFactory {

    public static DriverCommand createRectangle(Job2dDriver driver, int x, int y, int width, int height) {
        ComplexCommand rectangle = new ComplexCommand();
        rectangle.addCommand(new SetPositionCommand(x, y, driver));
        rectangle.addCommand(new OperateToCommand(x + width, y, driver));
        rectangle.addCommand(new OperateToCommand(x + width, y + height, driver));
        rectangle.addCommand(new OperateToCommand(x, y + height, driver));
        rectangle.addCommand(new OperateToCommand(x, y, driver));
        return rectangle;
    }

    public static DriverCommand createTriangle(Job2dDriver driver, int x, int y, int length) {
        ComplexCommand triangle = new ComplexCommand();
        int height = calculateTriangleHeight(length);
        triangle.addCommand(new SetPositionCommand(x, y, driver));
        triangle.addCommand(new OperateToCommand(x + length, y, driver));
        triangle.addCommand(new OperateToCommand(x + (length / 2), y - height, driver));
        triangle.addCommand(new OperateToCommand(x, y, driver));

        return triangle;
    }

    private static int calculateTriangleHeight(int length) {
        return (int) (Math.sqrt(3.0) / 2 * length);
    }
}
