package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.factory.Job2dFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int figureTestNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureTestNumber) {
		this.driverManager = driverManager;
		this.figureTestNumber = figureTestNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (figureTestNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				Job2dFactory.createRectangle(driverManager.getCurrentDriver()).execute();
				break;
			case 4:
				Job2dFactory.createTriangle(driverManager.getCurrentDriver()).execute();
				break;
			default:
				break;
		}
	}
}
