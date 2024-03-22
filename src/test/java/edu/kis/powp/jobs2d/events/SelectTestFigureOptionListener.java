package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.FigureFactory;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	int figuresJoeScriptNumber;


	public SelectTestFigureOptionListener(DriverManager driverManager, int figuresJoeScriptNumber) {
		this.driverManager = driverManager;
		this.figuresJoeScriptNumber = figuresJoeScriptNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.figuresJoeScriptNumber == 1)
		{
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		else if(this.figuresJoeScriptNumber == 2)
		{
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		}
		else if(this.figuresJoeScriptNumber == 3)
		{
			ComplexCommand complexCommand = FigureFactory.getHouse(driverManager.getCurrentDriver(), -120, 0, 200);
			complexCommand.execute();
		}
	}
}
