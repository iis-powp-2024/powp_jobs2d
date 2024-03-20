package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.factories.DiamondFactory;
import edu.kis.powp.jobs2d.factories.RectangleFactory;
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
		DriverCommand command;
		switch (this.figureNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				command = new RectangleFactory(driverManager.getCurrentDriver()).getRectangle();
				command.execute();
				break;
			case 4:
				command = new DiamondFactory(driverManager.getCurrentDriver()).getDiamond();
				command.execute();
				break;
		}
	}
}
