package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.FigureFactory;
import edu.kis.powp.enums.Figures;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	Figures figures;


	public SelectTestFigureOptionListener(DriverManager driverManager, Figures figures) {
		this.driverManager = driverManager;
		this.figures = figures;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ComplexCommand complexCommand = null;
		switch(this.figures)
		{
			case JOE_SCRIPT1:
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case JOE_SCRIPT2:
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case TRIANGLE:
				complexCommand = FigureFactory.getTriangle(driverManager.getCurrentDriver(), -120, 0, 200, 100);
				break;
			case RECTANGLE:
				complexCommand = FigureFactory.getRectangle(driverManager.getCurrentDriver(), -120, -150, 200, 300);
				break;
			case HOUSE:
				complexCommand = FigureFactory.getHouse(driverManager.getCurrentDriver(), -120, 0, 200);
				break;
		}
		if(complexCommand != null)
		{
			complexCommand.execute();
		}
	}
}
