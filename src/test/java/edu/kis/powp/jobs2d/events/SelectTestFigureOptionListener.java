package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.factory.CommandJob2dFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	FigureTest figureTestType;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureTest figureTestType) {
		this.driverManager = driverManager;
		this.figureTestType = figureTestType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (figureTestType) {
			case FIGURE_SCRIPT_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_SCRIPT_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case RECTANGLE:
				CommandJob2dFactory.createRectangle(driverManager.getCurrentDriver()).execute();
				break;
			case TRIANGLE:
				CommandJob2dFactory.createTriangle(driverManager.getCurrentDriver()).execute();
				break;
			default:
				break;
		}
	}
}
