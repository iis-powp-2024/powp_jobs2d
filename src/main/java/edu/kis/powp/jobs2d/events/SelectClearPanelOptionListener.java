package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.ControllerAdapter;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectClearPanelOptionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Job2dDriver driver = DriverFeature.getDriverManager().getCurrentDriver();
		if (driver instanceof ControllerAdapter) {
			((ControllerAdapter) driver).clearPanel();
		}
	}
}
