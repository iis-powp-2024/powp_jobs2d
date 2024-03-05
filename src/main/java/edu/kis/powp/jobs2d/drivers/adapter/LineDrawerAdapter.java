package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

import static edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController;


public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {
    private int startX = 0, startY = 0;
    private int lineType = 1;
    public LineDrawerAdapter(int lineType) {
        super();
        this.lineType = lineType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = switch (lineType){
            case 1 -> LineFactory.getSpecialLine();
            case 2 -> LineFactory.getDottedLine();
            default -> throw new IllegalStateException("Unexpected value: " + lineType);
        };
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        this.setPosition(x, y);
        DrawPanelController drawPanelController = getDrawerController();
        drawPanelController.drawLine(line);
    }

    @Override
    public String toString() {
        return "@Q!$!@$!#@$(*#@&Q(%^*#@";
    }
}
