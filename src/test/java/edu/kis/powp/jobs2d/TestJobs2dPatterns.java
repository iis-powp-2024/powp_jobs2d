package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Enums.Script;
import edu.kis.powp.jobs2d.command.Exceptions.IncorrectInputException;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.SolidLineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {

        SelectTestFigureOptionListener selectTestFigureOptionListener1 = null;
        SelectTestFigureOptionListener selectTestFigureOptionListener2 = null;

		SelectTestFigureOptionListener selectTestRectangleListener = null;
		SelectTestFigureOptionListener selectTestTriangleListener = null;
		SelectTestFigureOptionListener selectTestCircleListener = null;

        try {

            selectTestFigureOptionListener1 = new SelectTestFigureOptionListener(
                    DriverFeature.getDriverManager(), Script.FIGURE_SCRIPT_1);

            selectTestFigureOptionListener2 = new SelectTestFigureOptionListener(
                    DriverFeature.getDriverManager(), Script.FIGURE_SCRIPT_2);

			selectTestTriangleListener = new SelectTestFigureOptionListener(
					DriverFeature.getDriverManager(), Script.TRIANGLE);

			selectTestRectangleListener = new SelectTestFigureOptionListener(
					DriverFeature.getDriverManager(), Script.RECTANGLE);

			selectTestCircleListener = new SelectTestFigureOptionListener(
					DriverFeature.getDriverManager(), Script.CIRCLE);

        } catch (IncorrectInputException ex) {
            ex.printStackTrace();
        }


        application.addTest("Figure Joe 1", selectTestFigureOptionListener1);
        application.addTest("Figure Joe 2", selectTestFigureOptionListener2);
		application.addTest("Rectangle", selectTestRectangleListener);
		application.addTest("Triangle", selectTestTriangleListener);
		application.addTest("Circle", selectTestCircleListener);
    }

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		Job2dDriver testDriver = new SolidLineDrawerAdapter();
		DriverFeature.addDriver("Buggy Simulator", testDriver);

		Job2dDriver customLineDriver = new LineDrawerAdapter();
		DriverFeature.addDriver("Custom Lines", customLineDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);

				app.setVisibility(true);
			}
		});
	}

}
