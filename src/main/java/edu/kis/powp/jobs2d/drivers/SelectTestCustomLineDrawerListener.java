package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectTestCustomLineDrawerListener implements ActionListener {

    private ILine lineType;

    public SelectTestCustomLineDrawerListener(ILine lineType) {
        this.lineType = validateLineType(lineType);
    }

    private ILine validateLineType(ILine lineType) {
        if (lineType == null)
            return LineFactory.getBasicLine();

        return lineType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LineDrawerAdapter.setLineType(this.lineType);
    }

}
