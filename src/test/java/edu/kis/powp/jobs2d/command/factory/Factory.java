package edu.kis.powp.jobs2d.command.factory;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.DrawingAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class Factory {
    public static ComplexCommand SquareShape(int x, int y){
        ComplexCommand figure = new ComplexCommand();
        DrawingAdapter lineDrawer = new DrawingAdapter();
        figure.addCommand(new SetPositionCommand(x, y, lineDrawer));
        figure.addCommand(new OperateToCommand(x + 100, y, lineDrawer));
        figure.addCommand(new OperateToCommand(x + 100,  y + 100, lineDrawer));
        figure.addCommand(new OperateToCommand(x, y + 100, lineDrawer));
        figure.addCommand(new OperateToCommand(x, y, lineDrawer));
        return figure;
    }
    public static ComplexCommand PentagonShape(int x, int y){
        ComplexCommand figure = new ComplexCommand();
        DrawingAdapter lineDrawer = new DrawingAdapter();
        figure.addCommand(new SetPositionCommand(x, y, lineDrawer));
        figure.addCommand(new OperateToCommand(x, y - 100, lineDrawer));
        figure.addCommand(new OperateToCommand(x + 90, y - 140, lineDrawer));
        figure.addCommand(new OperateToCommand(x + 150, y - 50, lineDrawer));
        figure.addCommand(new OperateToCommand(x + 90, y + 40, lineDrawer));
        figure.addCommand(new OperateToCommand(x, y, lineDrawer));
        return figure;
    }
    public static ComplexCommand TriangleShape(int x, int y){
        ComplexCommand figure = new ComplexCommand();
        DrawingAdapter lineDrawer = new DrawingAdapter();
        figure.addCommand(new SetPositionCommand(x, y, lineDrawer));
        figure.addCommand(new OperateToCommand(x, y + 50, lineDrawer));
        figure.addCommand(new OperateToCommand(x + 50, y + 50, lineDrawer));
        figure.addCommand(new OperateToCommand(x, y, lineDrawer));
        return figure;
    }
}
