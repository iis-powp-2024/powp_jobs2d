package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private static final String FIGURE_JOE_1 = "FiguresJoe1";
	private static final String FIGURE_JOE_2 = "FiguresJoe2";

	private final DriverManager driverManager;
	private final String figuresName;

	public SelectTestFigureOptionListener(DriverManager driverManager , String figuresName) {
		this.driverManager = driverManager;
		this.figuresName = figuresName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (figuresName) {
			case FIGURE_JOE_1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case FIGURE_JOE_2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			default:
				throw new IllegalArgumentException("Unknown figure name: " + figuresName);
		}

	}
}
