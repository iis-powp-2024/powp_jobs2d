package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.FigureFactory;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.Job2dDriverToDrawPanelAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {

		application.addTest("Figure Joe 1", e -> FiguresJoe.figureScript1(DriverFeature.getDriverManager().getCurrentDriver()));

		application.addTest("Figure Joe 2", e -> FiguresJoe.figureScript2(DriverFeature.getDriverManager().getCurrentDriver()));

		application.addTest("Figure Jane", e -> FiguresJane.figureScript(new AbstractDriverAdapter(DriverFeature.getDriverManager().getCurrentDriver())));

		application.addTest("Square", e -> FigureFactory.getSquare(DriverFeature.getDriverManager().getCurrentDriver()).execute());

		application.addTest("Triangle", e -> FigureFactory.getTriangle(DriverFeature.getDriverManager().getCurrentDriver()).execute());

		application.addTest("Rhombus", e -> FigureFactory.getRhombus(DriverFeature.getDriverManager().getCurrentDriver()).execute());

		application.addTest("Circle", e -> FigureFactory.getCircle(DriverFeature.getDriverManager().getCurrentDriver()).execute());

		application.addTest("Hexagon", e -> FigureFactory.getNSidedFigure(DriverFeature.getDriverManager().getCurrentDriver(), 6).execute());

		application.addTest("Dodecagon", e -> FigureFactory.getNSidedFigure(DriverFeature.getDriverManager().getCurrentDriver(), 12).execute());

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

		DrawPanelController drawPanelController = DrawerFeature.getDrawerController();
		Job2dDriver testDriver = new Job2dDriverToDrawPanelAdapter(drawPanelController);
		DriverFeature.addDriver("Buggy Simulator Driver", testDriver);

		Job2dDriver basicLineDriver = new LineDrawerAdapter(drawPanelController, LineFactory.getBasicLine());
		DriverFeature.addDriver("Basic Line Driver", basicLineDriver);

		Job2dDriver dottedLineDriver = new LineDrawerAdapter(drawPanelController, LineFactory.getDottedLine());
		DriverFeature.addDriver("Dotted Line Driver", dottedLineDriver);

		Job2dDriver specialLineDriver = new LineDrawerAdapter(drawPanelController, LineFactory.getSpecialLine());
		DriverFeature.addDriver("Special Line Driver", specialLineDriver);

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

				app.setVisibility(true);
			}
		});
	}

}
