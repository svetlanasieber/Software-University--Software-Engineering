package barracksWars.core;

import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	private static final String COMMANDS_PACKAGE_PATH = "barracksWars.core.commands.";
	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) {
		String result = "Invalid command";
		commandName = Character.toUpperCase(commandName.charAt(0)) +
				commandName.substring(1);

		try {
			Class<? extends Executable> clazz =
					(Class<? extends Executable>) Class.forName(COMMANDS_PACKAGE_PATH + commandName);
			Constructor<? extends Executable> ctor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			ctor.setAccessible(true);
			Executable executable = ctor.newInstance(data, this.repository, this.unitFactory);

			result = executable.execute();

		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
