package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.command.CommandFactory;
import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.adapter.DrawerDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {
		SelectTestFigureOptionListener selectTestFigure1OptionListener = new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), FiguresJoe::figureScript1);
		SelectTestFigureOptionListener selectTestFigure2OptionListener = new SelectTestFigureOptionListener(DriverFeature.getDriverManager(), FiguresJoe::figureScript2);
		ComplexCommand rectangleCommands = CommandFactory.createRectangle(0, 0, 100, 100);
		ComplexCommand circleCommands = CommandFactory.createCircle(0, 0, 100);

		application.addTest("Figure Joe 1", selectTestFigure1OptionListener);
		application.addTest("Figure Joe 2", selectTestFigure2OptionListener);
		application.addTest("Figure Rectangle", (ActionEvent e) -> rectangleCommands.execute(DriverFeature.getDriverManager()));
		application.addTest("Figure Circle", (ActionEvent e) -> circleCommands.execute(DriverFeature.getDriverManager()));
	}

	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DrawerDriver testDriver = new DrawerDriver(DrawerFeature.getDrawerController());
		LineDrawerAdapter lineDrawerAdapter = new LineDrawerAdapter(DrawerFeature.getDrawerController());

		DriverFeature.addDriver(loggerDriver.toString(), loggerDriver);
		DriverFeature.addDriver(testDriver.toString(), testDriver);
		DriverFeature.addDriver(lineDrawerAdapter.toString(), lineDrawerAdapter);


		DriverFeature.getDriverManager().setCurrentDriver(lineDrawerAdapter);
		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(false);
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

	private static void setupCustomLineDrawer(Application application) {
		application.addComponentMenu(LineDrawerAdapter.class, "Custom Line Driver");
		application.addComponentMenuElement(LineDrawerAdapter.class, "Basic Line", (ActionEvent e) -> setLineSupplierIfApplicable(LineFactory::getBasicLine));
		application.addComponentMenuElement(LineDrawerAdapter.class, "Dotted Line", (ActionEvent e) -> setLineSupplierIfApplicable(LineFactory::getDottedLine));
		application.addComponentMenuElement(LineDrawerAdapter.class, "Special Line", (ActionEvent e) -> setLineSupplierIfApplicable(LineFactory::getSpecialLine));
	}

	private static void setLineSupplierIfApplicable(Supplier<ILine> lineSupplier) {
		Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        if (!(currentDriver instanceof LineDrawerAdapter)) {
            logger.warning("Current driver is not a LineDrawerAdapter");
			return;
        }
		((LineDrawerAdapter) currentDriver).setLineSupplier(lineSupplier);

    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);
				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);
				setupCustomLineDrawer(app);

				app.setVisibility(true);
			}
		});
	}

}
