package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import enums.DriverType;

public class LineDrawerAdapter  extends DrawerFeature implements Job2dDriver {
    private int startX,startY;

    private final DriverType driverType;

    public LineDrawerAdapter(DriverType driverType) {
        super();
        this.driverType = driverType;
    }

    @Override
    public void setPosition(int x, int y) {
        startX = x;
        startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line;

        switch (this.driverType) {
            case SPECIAL_LINE: line = LineFactory.getSpecialLine(); break;
            case DOTTED_LINE: line = LineFactory.getDottedLine(); break;
            default:
            {
                throw new IllegalArgumentException("Select Correct Driver Type");
            }
        }

        line.setStartCoordinates(this.startX,this.startY);
        line.setEndCoordinates(x,y);
        this.setPosition(x,y);
        getDrawerController().drawLine(line);
    }

    @Override
    public String toString() {
        return "@Q!$!@$!#@$(*#@&Q(%^*#@";
    }
}
