package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;

public class LineDrawerAdapter extends DrawerAdapter {
    private int startX = 0, startY = 0;
    private ILine line = LineFactory.getBasicLine();

    public LineDrawerAdapter() {
        super();
    }

    public LineDrawerAdapter(ILine line) {
        super();
        setLine(line);
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = this.line;
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        setPosition(x, y);
        drawLine(line);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter";
    }

    public void setLine(ILine line) {
        this.line = line;
    }
}
