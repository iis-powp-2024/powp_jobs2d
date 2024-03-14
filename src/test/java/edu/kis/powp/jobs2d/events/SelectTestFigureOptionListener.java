package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final Consumer<Job2dDriver> figureScript;

	public SelectTestFigureOptionListener(DriverManager driverManager, Consumer<Job2dDriver> figureScript) {
		this.driverManager = driverManager;
		this.figureScript = figureScript;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		figureScript.accept(driverManager.getCurrentDriver());
	}
}
