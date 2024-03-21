package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.factory.ComplexCommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	public static final int TEST_FIGURES_JOE_1 = 1;
	public static final int TEST_FIGURES_JOE_2 = 2;
	public static final int TEST_SQUARE = 3;
	public static final int TEST_TRIANGLE = 4;

	final private DriverManager driverManager;
	final private int testIndex;

	public SelectTestFigureOptionListener(DriverManager driverManager, int testIndex) {
		this.driverManager = driverManager;
		this.testIndex = testIndex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (testIndex) {
			case TEST_FIGURES_JOE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case TEST_FIGURES_JOE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case TEST_SQUARE:
				ComplexCommandFactory factory = new ComplexCommandFactory();
				factory.drawSquare(driverManager.getCurrentDriver());
				break;
			case TEST_TRIANGLE:
				ComplexCommandFactory factory2 = new ComplexCommandFactory();
				factory2.drawTriangle(driverManager.getCurrentDriver());
				break;
		}
	}
}
