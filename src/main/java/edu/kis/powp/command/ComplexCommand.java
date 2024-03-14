package edu.kis.powp.command;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;

public class ComplexCommand implements DriverCommand {
    public List<DriverCommand> commands;
}
