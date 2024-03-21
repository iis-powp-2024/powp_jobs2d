package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.factory.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	public enum Figure {
		FIGURE1,
		FIGURE2,
		SQUARE,
		TRIANGLE,
	}

	private Figure chosenFigure;

	public SelectTestFigureOptionListener(DriverManager driverManager, Figure figure) {
		this.driverManager = driverManager;
		this.chosenFigure = figure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.chosenFigure == Figure.FIGURE1) {
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		} else if(this.chosenFigure == Figure.FIGURE2) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
		else if(this.chosenFigure == Figure.SQUARE) {
			ComplexCommandFactory complexCommandFactory = new ComplexCommandFactory();
			complexCommandFactory.createTriangle(driverManager.getCurrentDriver()).excecute();
		}
		else if(this.chosenFigure == Figure.TRIANGLE) {
			ComplexCommandFactory complexCommandFactory = new ComplexCommandFactory();
			complexCommandFactory.createSquare(driverManager.getCurrentDriver()).excecute();
		}
	}
}
