package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;
    private Figure selectedTestFigure;

    public SelectTestFigureOptionListener(DriverManager driverManager, Figure selectedTestFigure) {
        this.driverManager = driverManager;
        this.selectedTestFigure = selectedTestFigure;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (selectedTestFigure) {
            case FIGURE_JOE_1:
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;
            case FIGURE_JOE_2:
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;
            case RECTANGLE:
                ComplexCommand.createRectangle(driverManager.getCurrentDriver(), 0, 0, 200, 100).execute();
                break;
            case CIRCLE:
                ComplexCommand.createCircle(driverManager.getCurrentDriver(), 0, 0, 100).execute();
                break;
        }
    }
}
