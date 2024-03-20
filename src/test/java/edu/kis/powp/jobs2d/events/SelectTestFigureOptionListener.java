package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private String figuresName;

	public SelectTestFigureOptionListener(DriverManager driverManager , String figuresName) {
		this.driverManager = driverManager;
		this.figuresName = figuresName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (figuresName) {
			case "FiguresJoe1":
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case "FiguresJoe2":
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;



			default:
				throw new IllegalArgumentException("Unknown figure name: " + figuresName);
		}

	}
}
