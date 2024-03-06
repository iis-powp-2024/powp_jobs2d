package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.LoggerDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Driver manager provides means to setup the driver. It also enables other
 * components and features of the application to react on configuration changes.
 */
public class DriverManager {

	private Job2dDriver currentDriver = new LoggerDriver();
	private List<Job2dDriver> registeredDrivers = new ArrayList<>();

	/**
	 * @param driver Set the driver as current.
	 */
	public synchronized void setCurrentDriver(Job2dDriver driver) {
		currentDriver = driver;
	}

	/**
	 * @return Current driver.
	 */
	public synchronized Job2dDriver getCurrentDriver() {
		return currentDriver;
	}

	/**
	 * Register a new driver.
	 *
	 * @param driver Driver to be registered.
	 */
	public synchronized void registerDriver(Job2dDriver driver) {
		registeredDrivers.add(driver);
	}

	/**
	 * @return List of registered drivers.
	 */
	public synchronized List<Job2dDriver> getRegisteredDrivers() {
		return Collections.unmodifiableList(registeredDrivers);
	}

	/**
	 * Get the driver by name.
	 *
	 * @param driverName Name of the driver.
	 * @return Found driver or null if not found.
	 */
	public synchronized Job2dDriver getDriver(String driverName) {
		for (Job2dDriver registeredDriver : registeredDrivers) {
			if (registeredDriver.toString().equals(driverName)) {
				return registeredDriver;
			}
		}
		return null;
	}
}
