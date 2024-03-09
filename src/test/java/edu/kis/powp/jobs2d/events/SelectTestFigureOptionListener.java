package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int scenario = 1;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public SelectTestFigureOptionListener(DriverManager driverManager, int scenario) {
		this.driverManager = driverManager;
		this.scenario = scenario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(scenario==1)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		if(scenario==2)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
	}
}
