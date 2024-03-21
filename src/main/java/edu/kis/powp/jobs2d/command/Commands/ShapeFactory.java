package edu.kis.powp.jobs2d.command.Commands;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.Exceptions.IncorrectInputException;
import edu.kis.powp.jobs2d.command.Interfaces.DriverCommand;

import java.awt.*;

public class ShapeFactory {

    private static void validateInput(final Job2dDriver driver, final Point point, int width, int height) throws IncorrectInputException {
        if (driver == null)
            throw new IncorrectInputException("Driver cannot null!");

        if (point == null)
            throw new IncorrectInputException("Point cannot be null!");

        if (width < 1 || height < 1)
            throw new IncorrectInputException("Width and height must be > that 0!");
    }


    public static DriverCommand getRectangle(Job2dDriver driver, Point startPoint, int width, int height) throws IncorrectInputException {
        validateInput(driver, startPoint, width, height);

        int x = startPoint.x;
        int y = startPoint.y;

        ComplexCommand complexCmd = new ComplexCommand();

        complexCmd.addCommand(new SetPositionCommand(x, y, driver));
        complexCmd.addCommand(new OperateToCommand(x + width, y, driver));
        complexCmd.addCommand(new OperateToCommand(x + width, y + height, driver));
        complexCmd.addCommand(new OperateToCommand(x, y + height, driver));
        complexCmd.addCommand(new OperateToCommand(x, y, driver));

        return complexCmd;
    }

    public static DriverCommand getTriangle(Job2dDriver driver, Point startPoint, int length) throws IncorrectInputException {
        validateInput(driver, startPoint, length, length);

        int x = startPoint.x;
        int y = startPoint.y;
        ComplexCommand complexCmd = new ComplexCommand();

        int height = (int) (Math.sqrt(3) / 2 * length);

        complexCmd.addCommand(new SetPositionCommand(x, y, driver));
        complexCmd.addCommand(new OperateToCommand(x + length, y, driver));
        complexCmd.addCommand(new OperateToCommand(x + (length / 2), y - height, driver));
        complexCmd.addCommand(new OperateToCommand(x, y, driver));

        return complexCmd;
    }

    public static DriverCommand getCircle(Job2dDriver driver, Point center, int radius, int numVertices) throws IncorrectInputException {
        validateInput(driver, center, radius, numVertices);

        Point[] vertices = new Point[numVertices];
        double angleIncrement = 2 * Math.PI / numVertices;

        for (int i = 0; i < numVertices; i++) {
            double angle = i * angleIncrement;
            int x = (int) (center.x + radius * Math.cos(angle));
            int y = (int) (center.y + radius * Math.sin(angle));
            vertices[i] = new Point(x, y);
        }

        ComplexCommand complexCmd = new ComplexCommand();
        complexCmd.addCommand(new SetPositionCommand(vertices[0].x, vertices[0].y, driver));

        for (int i = 1; i < numVertices; i++)
            complexCmd.addCommand(new OperateToCommand(vertices[i].x, vertices[i].y, driver));

        complexCmd.addCommand(new OperateToCommand(vertices[0].x, vertices[0].y, driver));

        return complexCmd;
    }

}
