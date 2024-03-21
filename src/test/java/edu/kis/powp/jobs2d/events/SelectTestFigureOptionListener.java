package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.factory.CommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import static edu.kis.powp.jobs2d.events.FigureCase.*;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final FigureCase figureTestNumber;
	private int size;

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureCase figureTestCase) {
		this.driverManager = driverManager;
		this.figureTestNumber = figureTestCase;
	}

	public SelectTestFigureOptionListener(DriverManager driverManager, FigureCase figureTestCase, int size) {
		this.driverManager = driverManager;
		this.figureTestNumber = figureTestCase;
		this.size = size;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (figureTestNumber) {
			case ENVELOPE:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case SCRATCHES:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case RECTANGLE:
				CommandFactory.getRectangle(driverManager.getCurrentDriver(), this.size * 2, this.size).execute();
				break;
			case SQUARE:
				CommandFactory.getSquare(driverManager.getCurrentDriver(), this.size).execute();
				break;
			default:
				System.out.println("No such figure");
				break;
		}
	}
}
