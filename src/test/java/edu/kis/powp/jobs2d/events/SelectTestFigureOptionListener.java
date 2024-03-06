package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figType;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figType) {
		this.driverManager = driverManager;
		this.figType = figType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.figType == 1)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else if (this.figType == 2)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
