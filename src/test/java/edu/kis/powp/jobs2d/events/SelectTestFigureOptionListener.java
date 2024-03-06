package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private final int testNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int testNumber) {
		this.driverManager = driverManager;
		this.testNumber = testNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(testNumber == 1){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		if(testNumber == 2) {
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}

	}
}
