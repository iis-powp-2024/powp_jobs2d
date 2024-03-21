package edu.kis.powp.command.factory;
import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class ComplexCommandFactory {
    public static ComplexCommand createTriangle(Job2dDriver lineDrawer) {
        return new ComplexCommand(new DriverCommand[] {
                new OperateToCommand(0, 0, lineDrawer),
                new OperateToCommand(100, 150, lineDrawer),
                new OperateToCommand(150, 0, lineDrawer),
                new OperateToCommand(0, 0, lineDrawer)
        });
    }

    public static ComplexCommand createSquare(Job2dDriver lineDrawer) {
        return new ComplexCommand(new DriverCommand[] {
                new OperateToCommand(0, 0, lineDrawer),
                new OperateToCommand(0, 200, lineDrawer),
                new OperateToCommand(200, 200, lineDrawer),
                new OperateToCommand(200, 0, lineDrawer),
                new OperateToCommand(0, 0, lineDrawer)
        });
    }

}
