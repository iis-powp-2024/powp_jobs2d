package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

import javax.swing.*;

public class LineDrawerAdapter extends DrawPanelController implements Job2dDriver {

    private int startX;
    private int startY;
    ILine line = LineFactory.getBasicLine();

    public LineDrawerAdapter(JPanel panel) {
        super();
        super.initialize(panel);
    }

    @Override
    public void setPosition(int i, int i1) {
        this.startX = i;
        this.startY = i1;
    }

    public void setLineType(String lineType) {
        this.line = selectLineType(lineType);
        if (this.line == null) {
            this.line = LineFactory.getBasicLine();
            System.out.println("Invalid line type, using basic line");
        }
        System.out.println("Line type set to: " + lineType);
    }
    @Override
    public void operateTo(int i, int i1) {
        this.line.setStartCoordinates(this.startX, this.startY);
        this.line.setEndCoordinates(i, i1);
        drawLine(this.line);

        setPosition(i, i1);
    }

    private ILine selectLineType(String lineType){
        switch(lineType){
            case "basic":
                return LineFactory.getBasicLine();
            case "dotted":
                return LineFactory.getDottedLine();
            case "special":
                return LineFactory.getSpecialLine();
        }
        return null;
    }
}
