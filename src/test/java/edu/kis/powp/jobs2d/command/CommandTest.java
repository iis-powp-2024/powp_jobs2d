package edu.kis.powp.jobs2d.command;
import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class CommandTest {
    private static class Coords {
        private int x, y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        LineDrawerAdapter adapterSpecial = new LineDrawerAdapter(LineFactory.getSpecialLine());
        Coords[] coordsTest1 = new Coords[] {new Coords(0, 0), new Coords(100, 100), new Coords(0, 100)};
        SetPositionCommand setPositionCommand = new SetPositionCommand(coordsTest1[0].x, coordsTest1[0].y, adapterSpecial);
        setPositionCommand.execute();
        OperateToCommand operateToCommand = new OperateToCommand();
        operateToCommand.setDriver(adapterSpecial);
        for (int i = 1; i<=coordsTest1.length; i++) {
            operateToCommand.setPosition(coordsTest1[i% coordsTest1.length].x, coordsTest1[i% coordsTest1.length].y);
            operateToCommand.execute();
        }
    }
}