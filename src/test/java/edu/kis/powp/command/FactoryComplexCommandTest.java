package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class FactoryComplexCommandTest {

    public static ComplexCommand drawSquare(){
        ComplexCommand commands = new ComplexCommand();
        DrawPanelController controller = DrawerFeature.getDrawerController();
        LineDrawerAdapter adapter = new LineDrawerAdapter(controller, LineFactory.getSpecialLine());

        commands.addCommand(new SetPositionCommand(0, 0, adapter));
        commands.addCommand(new OperateToCommand(200, 0, adapter));
        commands.addCommand(new OperateToCommand(200, 200, adapter));
        commands.addCommand(new OperateToCommand(0, 200, adapter));
        commands.addCommand(new OperateToCommand(0, 0, adapter));

        return commands;
    }

    public static ComplexCommand drawTrapeze(){
        ComplexCommand commands = new ComplexCommand();
        DrawPanelController controller = DrawerFeature.getDrawerController();
        LineDrawerAdapter adapter = new LineDrawerAdapter(controller, LineFactory.getSpecialLine());

        commands.addCommand(new SetPositionCommand(0, 0, adapter));
        commands.addCommand(new OperateToCommand(200, 0, adapter));
        commands.addCommand(new OperateToCommand(200, 200, adapter));
        commands.addCommand(new OperateToCommand(-150, 200, adapter));
        commands.addCommand(new OperateToCommand(0, 0, adapter));

        return commands;
    }
}
