package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figureOptionNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureOptionNumber) {
		this.driverManager = driverManager;
		this.figureOptionNumber = figureOptionNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (figureOptionNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			default:
				break;
		}
	}
}
