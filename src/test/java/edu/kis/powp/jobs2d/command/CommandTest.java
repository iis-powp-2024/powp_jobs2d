package edu.kis.powp.jobs2d.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class CommandTest {
    public static void main(String[] args) {
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        LineDrawerAdapter adapterSpecial = new LineDrawerAdapter();
        SetPositionCommand setPositionCommand = new SetPositionCommand(-100, -100, adapterSpecial);
        setPositionCommand.execute();
        OperateToCommand operateToCommand = new OperateToCommand(100, 100, adapterSpecial);
        operateToCommand.execute();
        operateToCommand.setNewPosition(250, -250);
        operateToCommand.execute();
    }
}
