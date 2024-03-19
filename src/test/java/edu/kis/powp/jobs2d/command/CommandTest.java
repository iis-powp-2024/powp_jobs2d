package edu.kis.powp.jobs2d.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
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
        LineDrawerAdapter adapterSpecial = new LineDrawerAdapter();
        Coords[] coordsTest1 = new Coords[] {new Coords(300, 150), new Coords(100, 100), new Coords(250, -250)};
        SetPositionCommand setPositionCommand = new SetPositionCommand(coordsTest1[0].x, coordsTest1[0].y, adapterSpecial);
        setPositionCommand.execute();
        OperateToCommand operateToCommand = new OperateToCommand();
        operateToCommand.setDriver(adapterSpecial);
        for (int i = 1; i<=coordsTest1.length; i++) {
            operateToCommand.setNewPosition(coordsTest1[i% coordsTest1.length].x, coordsTest1[i% coordsTest1.length].y);
            operateToCommand.execute();
        }
        Coords[] coordsTest2 = new Coords[] {new Coords(0, 0), new Coords(-100, 0), new Coords(-100, -100), new Coords(0, -100)};
        setPositionCommand.setNewPosition(coordsTest2[0].x, coordsTest2[0].y);
        setPositionCommand.execute();
        for (int i = 1; i<=coordsTest2.length; i++) {
            operateToCommand.setNewPosition(coordsTest2[i% coordsTest2.length].x, coordsTest2[i% coordsTest2.length].y);
            operateToCommand.execute();
        }
    }
}
