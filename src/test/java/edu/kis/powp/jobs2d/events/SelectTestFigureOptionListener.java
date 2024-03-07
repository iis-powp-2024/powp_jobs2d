package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;

public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;
	private final FiguresJoeScript figuresJoeScript;

	public SelectTestFigureOptionListener(DriverManager driverManager, FiguresJoeScript figuresJoeScript) {
		this.driverManager = driverManager;
		this.figuresJoeScript = figuresJoeScript;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		figuresJoeScript.execute(driverManager.getCurrentDriver());
	}

	public interface FiguresJoeScript {
		void execute(Job2dDriver driver);
	}
}
