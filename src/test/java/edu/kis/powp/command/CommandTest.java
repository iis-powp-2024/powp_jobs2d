package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class CommandTest {
    public static void main(String[] args) {
        DrawPanelController controller = new DrawPanelController();
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        LineDrawerAdapter adapter = new LineDrawerAdapter(controller, LineFactory.getSpecialLine());

        SetPositionCommand positionCommand = new SetPositionCommand(-100, -60, adapter);
        positionCommand.execute();
        OperateToCommand operateToCommand = new OperateToCommand(60, 130, adapter);
        operateToCommand.execute();
    }
}
