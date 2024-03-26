package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import edu.kis.powp.jobs2d.drivers.DriverCommand;
import edu.kis.powp.jobs2d.drivers.command.CommandFactory;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int figureNum;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureNum) {
		this.driverManager = driverManager;
		this.figureNum = figureNum;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (figureNum == 1)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		else if (figureNum == 2)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		else if (figureNum == 3){
			DriverCommand command = CommandFactory.makeSquare(driverManager.getCurrentDriver(), -50, -50, 200);
			command.execute();
		}
		else{
			CommandFactory.makeTriangle(driverManager.getCurrentDriver(),
					-50, -50, 100, 69, 40, 50).execute();
		}

	}
}
