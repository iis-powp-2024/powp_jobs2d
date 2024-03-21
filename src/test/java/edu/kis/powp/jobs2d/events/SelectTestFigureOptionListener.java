package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.command.CommandFactory;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	private int commandNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int commandNumber) {
		this.driverManager = driverManager;
		this.commandNumber = commandNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (commandNumber){
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				DriverCommand command = CommandFactory.makeSquare(driverManager.getCurrentDriver(), -50, -50, 200);
				command.execute();
				break;
			case 4:
				CommandFactory.makeTriangle(driverManager.getCurrentDriver(),
						-50, -50, 100, 69, 40, 50).execute();
				break;
		}
	}
}
