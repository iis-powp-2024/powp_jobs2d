package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private String figureName;

	public SelectTestFigureOptionListener(DriverManager driverManager, String figureName) {
		this.driverManager = driverManager;
		this.figureName = figureName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (figureName) {
			case "Figure Joe 1":
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case "Figure Joe 2":
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			default:
				System.err.println("Unknown figure name: " + figureName);
		}
	}
}
