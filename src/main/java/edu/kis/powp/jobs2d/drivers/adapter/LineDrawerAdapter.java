package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

import static edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController;

public class LineDrawerAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private int lineType;

    public LineDrawerAdapter(int lineType) {
        this.lineType = lineType;
    }
    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine iLine;
        if (lineType == 2) {
            iLine = LineFactory.getDottedLine();
        } else {
            iLine = LineFactory.getSpecialLine();
        }
        iLine.setStartCoordinates(this.startX, this.startY);
        iLine.setEndCoordinates(x, y);
        this.setPosition(x, y);
        DrawPanelController drawPanelController = getDrawerController();
        drawPanelController.drawLine(iLine);
    }

    @Override
    public String toString() {
        return "SpecialLine";
    }
}
