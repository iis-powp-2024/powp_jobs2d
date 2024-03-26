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
		switch (figureNum) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				DriverCommand squareCommand = CommandFactory.makeSquare(driverManager.getCurrentDriver(), -50, -50, 200);
				squareCommand.execute();
				break;
			case 4:
				DriverCommand triangleCommand = CommandFactory.makeTriangle(driverManager.getCurrentDriver(),
						-50, -50, 100, 69, 40, 50);
				triangleCommand.execute();
				break;
			default:
				DriverCommand circleCommand = CommandFactory.makeCircle(driverManager.getCurrentDriver(),
						50, 50, 30);
				circleCommand.execute();
				break;
		}


	}
}
