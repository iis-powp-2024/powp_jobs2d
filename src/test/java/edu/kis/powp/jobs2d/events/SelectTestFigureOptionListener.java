package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int a;

	public SelectTestFigureOptionListener(DriverManager driverManager, int a) {
		this.driverManager = driverManager;
		this.a = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(a == 1)
		{
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		else
		{
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}

	}
}
