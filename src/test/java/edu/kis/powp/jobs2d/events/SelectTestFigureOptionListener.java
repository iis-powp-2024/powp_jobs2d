package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.ShapeFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import enums.TestOption;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final TestOption option;

	public SelectTestFigureOptionListener(DriverManager driverManager,TestOption option) {
		this.option = option;
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(this.option.toString());
		switch(this.option){
			case FIGURE_SCRIPT_1: FiguresJoe.figureScript1(driverManager.getCurrentDriver());break;
			case FIGURE_SCRIPT_2: FiguresJoe.figureScript2(driverManager.getCurrentDriver());break;
			case CIRCLE: ShapeFactory.createCircle(0,0,50, driverManager.getCurrentDriver()).execute();break;
			case RECTANGLE: ShapeFactory.createRectangle(0,0,50,100, driverManager.getCurrentDriver()).execute();break;
		}
	}
}
