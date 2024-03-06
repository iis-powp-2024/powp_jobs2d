package edu.kis.powp.jobs2d.drivers;

import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.features.DriverFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDriverMenuOptionListener implements ActionListener {
    private DriverManager driverManager;
    private Job2dDriver driver = null;
    private Application application;
    private boolean areTestsInserted = false;

    public SelectDriverMenuOptionListener(Job2dDriver driver, DriverManager driverManager, Application app) {
        this.driverManager = driverManager;
        this.driver = driver;
        this.application = app;
    }

    private void showTestsForCustomLineDrawer() {
        if (areTestsInserted)
            return;

        SelectTestCustomLineDrawerListener dottedLine = new SelectTestCustomLineDrawerListener(LineFactory.getDottedLine());
        SelectTestCustomLineDrawerListener specialLine = new SelectTestCustomLineDrawerListener(LineFactory.getSpecialLine());

        application.addTest("Dotted Line (after that select test!)", dottedLine);
        application.addTest("Special Line (after that select test!)", specialLine);

        areTestsInserted = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (driver instanceof LineDrawerAdapter)
            showTestsForCustomLineDrawer();

        driverManager.setCurrentDriver(driver);
        DriverFeature.updateDriverInfo();
    }
}
