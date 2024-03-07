package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.Job2dDriver;

import javax.swing.*;

public abstract class AbstractAdapter extends DrawPanelController implements Job2dDriver  {

    protected int startX,startY;
    protected JPanel panel;

    public abstract void activate();

}
