package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int testNumber;

	public SelectTestFigureOptionListener(DriverManager driverManager, int testNumber) {
		this.driverManager = driverManager;
		this.testNumber = validateTestNumber(testNumber);
	}

	private int validateTestNumber(int testNumber) {

		switch (testNumber) {

            case 2:
				return 2;

			default:
				return 1;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (testNumber) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;

			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());

			default:
				break;
		}

	}
}
