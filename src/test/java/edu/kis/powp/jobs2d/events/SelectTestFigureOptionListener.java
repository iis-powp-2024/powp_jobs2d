package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.command.CircleFactory;
import edu.kis.powp.jobs2d.command.RectangleFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	private int selectedFigure;

	public SelectTestFigureOptionListener(DriverManager driverManager, int selectedFigure) {
		this.driverManager = driverManager;
		this.selectedFigure = selectedFigure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (selectedFigure) {
			case 1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case 2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case 3:
				RectangleFactory.createRectangle(driverManager.getCurrentDriver(), 0, 0, 150, 100).execute();
				break;
			case 4:
				CircleFactory.createCircle(driverManager.getCurrentDriver(), 0, 0, 100).execute();
				break;
		}
    }
}
