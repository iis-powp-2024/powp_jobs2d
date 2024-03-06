package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

import static edu.kis.powp.jobs2d.features.DrawerFeature.getDrawerController;

public class LineDrawerAdapter implements Job2dDriver {

    private int startX = 0;
    private int startY = 0;

    private static ILine lineType;

    public LineDrawerAdapter() {
        lineType = LineFactory.getBasicLine();
    }

    public static void setLineType(ILine lineType) {
        if (lineType == null) {
            LineDrawerAdapter.lineType = LineFactory.getBasicLine();
            return;
        }

        LineDrawerAdapter.lineType = lineType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = lineType;

        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        setPosition(x, y);

        getDrawerController().drawLine(line);
    }

    @Override
    public String toString() {
        return "Custom line drawer adapter";
    }

}
