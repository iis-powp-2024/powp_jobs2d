package edu.kis.powp.jobs2d.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class TestComplexCommand {
    public static void main(String[] args) {
        DrawPanelController controller = new DrawPanelController();
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);

        Job2dDriver specialLineDriver = new LineDrawerAdapter(
                controller, LineFactory.getSpecialLine());

        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.addCommand(new OperateToCommand(1000, 1000, specialLineDriver));
        complexCommand.popCommand();

        for (int i = 0; i < 4; i++) {
            complexCommand.addCommand(new SetPositionCommand(-100 + i * 50, -100 + i * 50, specialLineDriver));
            complexCommand.addCommand(new OperateToCommand(100 + i * 50, -100 + i * 50, specialLineDriver));
        }

        complexCommand.addCommand(1, new OperateToCommand(-1000, -1000, specialLineDriver));
        complexCommand.removeCommand(1);

        complexCommand.execute();
    }
}
