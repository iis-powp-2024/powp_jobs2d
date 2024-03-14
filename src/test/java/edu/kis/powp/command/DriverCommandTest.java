package edu.kis.powp.command;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDrawer;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

import java.util.ArrayList;

public class DriverCommandTest {
    public static void main(String[] args) {
        DrawPanelController controller = new DrawPanelController();
        DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
        LineDrawerAdapter drawer = new LineDrawerAdapter(controller, LineDrawerAdapter.lineTypeEnum.dotted);

        SetPositionCommand setPositionCommand = new SetPositionCommand(0,0,drawer);
        setPositionCommand.execute();

        ArrayList<OperateToCommand> listOfOperations = new ArrayList<>();
        listOfOperations.add(new OperateToCommand(100,0, drawer));
        listOfOperations.add(new OperateToCommand(100,100, drawer));
        listOfOperations.add(new OperateToCommand(0,100, drawer));
        listOfOperations.add(new OperateToCommand(0,0, drawer));
        for(int i = 0; i < listOfOperations.size(); i++){
            listOfOperations.get(i).execute();
        }
    }
}
