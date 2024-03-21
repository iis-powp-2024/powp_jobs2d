package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Enums.Script;
import edu.kis.powp.jobs2d.command.Commands.ShapeFactory;
import edu.kis.powp.jobs2d.command.Exceptions.IncorrectInputException;
import edu.kis.powp.jobs2d.command.Interfaces.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;

    private Script script;

    public SelectTestFigureOptionListener(DriverManager driverManager, Script script) throws IncorrectInputException {

        if (driverManager == null || script == null)
            throw new IncorrectInputException("Input cannot be null!");

        this.driverManager = driverManager;
        this.script = script;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand cmd = null;

        try {

            switch (script) {
                case FIGURE_SCRIPT_1:
                    FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                    break;

                case FIGURE_SCRIPT_2:
                    FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                    break;

                case RECTANGLE:
                    cmd = ShapeFactory.getRectangle(driverManager.getCurrentDriver(), new Point(-100, -100), 150, 100);
                    cmd.execute();
                    break;

                case TRIANGLE:
                    cmd = ShapeFactory.getTriangle(driverManager.getCurrentDriver(), new Point(0, 0), 100);
                    cmd.execute();
                    break;

                case CIRCLE:
                    cmd = ShapeFactory.getCircle(driverManager.getCurrentDriver(), new Point(0, 0), 100, 1000);
                    cmd.execute();
                    break;

                default:
                    break;
            }

        } catch (IncorrectInputException ex) {
            ex.printStackTrace();
        }


    }
}
