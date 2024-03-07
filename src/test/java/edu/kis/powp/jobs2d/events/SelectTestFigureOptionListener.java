package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private final int number;

	public SelectTestFigureOptionListener(DriverManager driverManager, int number) {
		this.driverManager = driverManager;
		this.number = number;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(number==1){
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		else if(number==2){
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
	}
}
