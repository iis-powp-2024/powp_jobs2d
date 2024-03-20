package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

    private DriverManager driverManager;
    private int selectedTestFigure;

    public SelectTestFigureOptionListener(DriverManager driverManager, int selectedTestFigure) {
        this.driverManager = driverManager;
        this.selectedTestFigure = selectedTestFigure;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (selectedTestFigure) {
            case 1:
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;
            case 2:
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;
            case 3:
                ComplexCommand.createRectangle(driverManager.getCurrentDriver(), 0, 0, 200, 100).execute();
                break;
            case 4:
                ComplexCommand.createCircle(driverManager.getCurrentDriver(), 0, 0, 100).execute();
                break;
        }
    }
}
