package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.commands.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.factories.DiamondFactory;
import edu.kis.powp.jobs2d.factories.RectangleFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestFigureOptionListener implements ActionListener {

    private final DriverManager driverManager;
    Figures figureType;

    public SelectTestFigureOptionListener(DriverManager driverManager, Figures figureType) {
        this.driverManager = driverManager;
        this.figureType = figureType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command;

        switch (figureType) {
            case figureJoe1:
                FiguresJoe.figureScript1(driverManager.getCurrentDriver());
                break;

            case figureJoe2:
                FiguresJoe.figureScript2(driverManager.getCurrentDriver());
                break;

            case rectangleFigure:
                command = new RectangleFactory(driverManager.getCurrentDriver()).getRectangle();
                command.execute();
                break;

            case diamondFactory:
                command = new DiamondFactory(driverManager.getCurrentDriver()).getDiamond();
                command.execute();
                break;
        }
    }
}
