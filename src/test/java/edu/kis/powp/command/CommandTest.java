package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverAdapter;

public class CommandTest {
    public static void main(String[] args) {
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        Job2dDriver adapter = new DriverAdapter();
        //adapter.setPosition(-100, -60);
        SetPositionCommand positionCommand = new SetPositionCommand(-100, -60, adapter);
        positionCommand.execute();
        OperateToCommand operateToCommand = new OperateToCommand(60, 130, adapter);
        operateToCommand.execute();
    }
}
