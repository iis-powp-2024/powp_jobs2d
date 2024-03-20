package edu.kis.powp.jobs2d.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class TestCommandPattern {
    public static void main(String[] args) {
        DrawPanelController controller = new DrawPanelController();
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);

        Job2dDriver basicLineDriver = new LineDrawerAdapter(
                controller, LineFactory.getBasicLine());

        DriverCommand [] driverCommands = {
                new SetPositionCommand(-100, -100, basicLineDriver),
                new OperateToCommand(100, -100, basicLineDriver),
                new OperateToCommand(100, 100, basicLineDriver),
                new OperateToCommand(-100, 100, basicLineDriver),
                new OperateToCommand(-100, -100, basicLineDriver),
        };

        for (DriverCommand command : driverCommands) {
            command.execute();
        }

    }
}
