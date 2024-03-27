package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverCommands.CommandFactory;
import edu.kis.powp.jobs2d.drivers.DriverCommands.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	public final static int FIGURE_SCRIPT_1 = 1;
	public final static int FIGURE_SCRIPT_2 = 2;
	public final static int SQUARE_SCRIPT = 3;
	public final static int TRIANGLE_SCRIPT = 4;
	public final static int CIRCLE_SCRIPT = 5;
	private final int START_X = 0;
	private final int START_Y = 0;
	private final int DEFAULT_UNIT = 60;
	private DriverManager driverManager;
	private int scenario;


	public SelectTestFigureOptionListener(DriverManager driverManager, int scenario) {
		this.driverManager = driverManager;
		this.scenario = scenario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(scenario==FIGURE_SCRIPT_1)
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		if(scenario==FIGURE_SCRIPT_2)
			FiguresJoe.figureScript2(driverManager.getCurrentDriver());
		if(scenario==SQUARE_SCRIPT)
		{
			CommandFactory factory = new CommandFactory();
			ComplexCommand command = factory.getSquare(driverManager.getCurrentDriver(), START_X, START_Y, DEFAULT_UNIT);
			command.execute();
		}
		if(scenario==TRIANGLE_SCRIPT)
		{
			CommandFactory factory = new CommandFactory();
			ComplexCommand command = factory.getTriangle(driverManager.getCurrentDriver(), START_X, START_Y, DEFAULT_UNIT);
			command.execute();
		}
		if(scenario==CIRCLE_SCRIPT)
		{
			CommandFactory factory = new CommandFactory();
			ComplexCommand command = factory.getCircle(driverManager.getCurrentDriver(), START_X, START_Y, DEFAULT_UNIT);
			command.execute();
		}
	}
}
