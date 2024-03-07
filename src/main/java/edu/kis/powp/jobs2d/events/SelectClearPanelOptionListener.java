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
		// needs to be extracted into some interface cause this hurts my eyes
		else if (driver instanceof edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter) {
			((edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter) driver).clearPanel();
		}
	}
}
