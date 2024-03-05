package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int figureNumber;


	public SelectTestFigureOptionListener(DriverManager driverManager, int figureNumber) {
		this.driverManager = driverManager;
		this.figureNumber = figureNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (this.figureNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
		}
	}
}
