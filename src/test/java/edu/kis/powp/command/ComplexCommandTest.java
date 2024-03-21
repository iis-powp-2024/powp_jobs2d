package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class ComplexCommandTest {

    public static void main(String[] args) {
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);

        Job2dDriver basicLineDriver = new LineDrawerAdapter(new DrawPanelController(), LineFactory.getBasicLine());

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