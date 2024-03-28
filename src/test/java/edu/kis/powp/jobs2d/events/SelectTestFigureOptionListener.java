package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final int selectedFigureNumber;
	public static final int FIGURE_1 = 1;
	public static final int FIGURE_2 = 2;

	public SelectTestFigureOptionListener(DriverManager driverManager, int selectedFigureNumber) {
		this.driverManager = driverManager;
		this.selectedFigureNumber = selectedFigureNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (selectedFigureNumber) {
			case FIGURE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			default:
				System.out.println("No existing figure");
				break;
		}
	}
}
