package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

import javax.swing.*;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver{
    private int startX = 0, startY = 0;
    private DrawPanelController drawer;
    public enum lineTypeEnum{
        special, dotted, basic
    }
    private lineTypeEnum lineType;

    public LineDrawerAdapter(DrawPanelController drawer, lineTypeEnum lineType) {
        super();
        this.drawer = drawer;
        this.lineType = lineType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line;
        if (lineType == lineTypeEnum.dotted) {
            line = LineFactory.getDottedLine();
        } else if(lineType == lineTypeEnum.special){
            line = LineFactory.getSpecialLine();
        }
        else {
            line = LineFactory.getBasicLine();
        }

        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        startX = x;
        startY = y;

        drawer.drawLine(line);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter";
    }
}
