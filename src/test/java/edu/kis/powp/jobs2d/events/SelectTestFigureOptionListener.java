package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.ComplexFactoryCommand;
import edu.kis.powp.jobs2d.drivers.command.DriverCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int testNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int testNumber) {
		this.driverManager = driverManager;
		this.testNumber = testNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DriverCommand command;
		switch (testNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				command = ComplexFactoryCommand.rectangle(driverManager.getCurrentDriver(), 0, 0, 100, 100);
				command.execute();
				break;
			case 4:
				command = ComplexFactoryCommand.circle(driverManager.getCurrentDriver(), 0, 0, 50);
				command.execute();
				break;
		}
	}
}
