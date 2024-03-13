package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter implements Job2dDriver {
    private ILine lineType;
    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;


    public LineDrawerAdapter(DrawPanelController drawPanelController) {
        this.setLineType("basicline");
        this.drawPanelController = drawPanelController;
    }

    @Override
    public void setPosition(int x, int y) {
        startX = x;
        startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        ILine line = lineType;
        line.setStartCoordinates(startX, startY);
        line.setEndCoordinates(x, y);
        this.setPosition(x, y);
        this.drawPanelController.drawLine(line);
    }

    public void setLineType(String lineType) {
        String lowerLineType = lineType.toLowerCase();
        switch (lowerLineType){
            case "dottedline":
                this.lineType = LineFactory.getDottedLine();
                break;
            case "specialline":
                this.lineType = LineFactory.getSpecialLine();
                break;
            default:
                this.lineType = LineFactory.getBasicLine();
                break;
        }
    }

    @Override
    public String toString(){
        return "Line drawer.";
    }
}
