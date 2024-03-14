package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDrawer;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class DriverCommandTest {
    public static void main(String[] args) {
        DrawPanelController controller = new DrawPanelController();
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        LineDrawerAdapter drawer = new LineDrawerAdapter(controller, LineDrawerAdapter.lineTypeEnum.dotted);

        SetPositionCommand setPositionCommand = new SetPositionCommand(0,0,drawer);
        setPositionCommand.execute();

        OperateToCommand operateDown = new OperateToCommand(100,0, drawer);
        OperateToCommand operateDownRight = new OperateToCommand(100,100, drawer);
        OperateToCommand operateUpRight = new OperateToCommand(0,100, drawer);
        OperateToCommand operateUpLeft = new OperateToCommand(0,0, drawer);
        operateDown.execute();
        operateDownRight.execute();
        operateUpRight.execute();
        operateUpLeft.execute();
    }
}
