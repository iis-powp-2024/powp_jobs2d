package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class ComplexCommandFactory {
    public static ComplexCommand getSquare(DrawPanelController drawPanelController, LineDrawerAdapter.lineTypeEnum lineType){
        ComplexCommand commands = new ComplexCommand();
        LineDrawerAdapter drawer = new LineDrawerAdapter(drawPanelController, lineType);

        commands.addCommand(new SetPositionCommand(0,0, drawer));
        commands.addCommand(new OperateToCommand(100,0, drawer));
        commands.addCommand(new OperateToCommand(100,100, drawer));
        commands.addCommand(new OperateToCommand(0,100, drawer));
        commands.addCommand(new OperateToCommand(0,0, drawer));

        return commands;
    }
    public static ComplexCommand getTriangle(DrawPanelController drawPanelController, LineDrawerAdapter.lineTypeEnum lineType){
        ComplexCommand commands = new ComplexCommand();
        LineDrawerAdapter drawer = new LineDrawerAdapter(drawPanelController, lineType);

        commands.addCommand(new SetPositionCommand(0,0, drawer));
        commands.addCommand(new OperateToCommand(100,50, drawer));
        commands.addCommand(new OperateToCommand(0,100, drawer));
        commands.addCommand(new OperateToCommand(0,0, drawer));

        return commands;
    }
    public static ComplexCommand getHexagon(DrawPanelController drawPanelController, LineDrawerAdapter.lineTypeEnum lineType){
        ComplexCommand commands = new ComplexCommand();
        LineDrawerAdapter drawer = new LineDrawerAdapter(drawPanelController, lineType);

        commands.addCommand(new SetPositionCommand(0,0, drawer));
        commands.addCommand(new OperateToCommand(50,25, drawer));
        commands.addCommand(new OperateToCommand(50,75, drawer));
        commands.addCommand(new OperateToCommand(0,100, drawer));
        commands.addCommand(new OperateToCommand(-50,75, drawer));
        commands.addCommand(new OperateToCommand(-50,25, drawer));
        commands.addCommand(new OperateToCommand(0,0, drawer));

        return commands;
    }
}
