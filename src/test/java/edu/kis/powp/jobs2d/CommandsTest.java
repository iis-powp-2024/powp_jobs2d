package edu.kis.powp.jobs2d;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.commands.OperateToCommand;
import edu.kis.powp.jobs2d.commands.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

public class CommandsTest {

    public static void main(String[] args) {
        int[][] testPositions = setupPositions();

        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);

        LineDrawerAdapter adapterSpecial = new LineDrawerAdapter(LineFactory.getSpecialLine());

        SetPositionCommand setPositionCommand = new SetPositionCommand(testPositions[0][0], testPositions[0][1], adapterSpecial);
        setPositionCommand.execute();

        OperateToCommand operateToCommand = new OperateToCommand(testPositions[0][0], testPositions[0][1], adapterSpecial);
        for (int i = 1; i <= testPositions.length; i++) {
            operateToCommand.setPosition(testPositions[i][0], testPositions[i][1]);
            operateToCommand.execute();
        }
    }
    
    private static int[][] setupPositions() {
        int[][] positions = new int[5][2];

        positions[0][0] = 0;
        positions[0][1] = 0;

        positions[1][0] = 100;
        positions[1][1] = 0;

        positions[2][0] = 100;
        positions[2][1] = 100;

        positions[3][0] = 0;
        positions[3][1] = 100;

        positions[4][0] = 0;
        positions[4][1] = 0;

        return positions;
    }
}