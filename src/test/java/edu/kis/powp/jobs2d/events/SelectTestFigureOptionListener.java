package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.factory.Job2dFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int figureTestNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int figureTestNumber) {
		this.driverManager = driverManager;
		this.figureTestNumber = figureTestNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (figureTestNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				Job2dFactory.getRectangle(driverManager.getCurrentDriver(), 200, 100).execute();
				break;
			case 4:
				Job2dFactory.getSquare(driverManager.getCurrentDriver(), 100).execute();
				break;
			default:
				System.out.println("No such figure");
				break;
		}
	}
}
