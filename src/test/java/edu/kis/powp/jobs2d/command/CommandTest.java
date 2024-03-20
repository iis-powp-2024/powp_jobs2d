package edu.kis.powp.jobs2d.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class CommandTest {
    public static void main(String[] args) {
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);

        LineDrawerAdapter lineDrawer = new LineDrawerAdapter(LineFactory.getBasicLine());
        SetPositionCommand setPosCom = new SetPositionCommand(0, 0, lineDrawer);
        setPosCom.execute();

        OperateToCommand operateToCom = new OperateToCommand(0, 100, lineDrawer);
        operateToCom.execute();

        operateToCom.setNewPosition(100, 100);
        operateToCom.execute();

        operateToCom.setNewPosition(100, 0);
        operateToCom.execute();

        operateToCom.setNewPosition(0, 0);
        operateToCom.execute();
    }
}