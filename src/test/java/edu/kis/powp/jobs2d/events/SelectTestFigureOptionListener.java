package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final Consumer<Job2dDriver> figure;

	public SelectTestFigureOptionListener(DriverManager driverManager, Consumer<Job2dDriver> figure) {
		this.driverManager = driverManager;
		this.figure = figure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		figure.accept(driverManager.getCurrentDriver());
	}
}
