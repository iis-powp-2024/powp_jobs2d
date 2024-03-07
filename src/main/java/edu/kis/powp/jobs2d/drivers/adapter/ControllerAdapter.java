package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;

import javax.swing.*;

/**
 * driver adapter to drawer with several bugs.
 */
public class ControllerAdapter extends AbstractAdapter {
	public ControllerAdapter(JPanel panel) {
		super();
		this.panel = panel;
		super.initialize(panel);
	}
	public void activate() {
		super.initialize(panel);
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		drawLine(line);

		setPosition(x,y);

	}

	@Override
	public String toString() {
		return "Working Driver";
	}
}
