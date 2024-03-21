package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter  extends DrawerFeature implements Job2dDriver {
    private int startX,startY;
    private final ILine type;

    public LineDrawerAdapter(ILine type) {
        super();
        this.type = type;
    }

    @Override
    public void setPosition(int x, int y) {
        startX = x;
        startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = LineFactory.getSpecialLine();

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