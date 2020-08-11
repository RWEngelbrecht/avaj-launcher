package avaj.simulator;

import java.io.*;
import java.util.*;
import avaj.simulator.interfaces.*;
import avaj.simulator.interfaces.Flyable;
import avaj.aircraft.*;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	public static PrintWriter printWriter = null;

	public static void main(String[] arg) throws InterruptedException {
		if (arg.length > 1)
			throw new IllegalArgumentException();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			File simulation = new File("./simulation.txt");
			printWriter = new PrintWriter(simulation);

			if (line != null) {
				int simulations = Integer.parseInt(line.split(" ")[0]);

				if (simulations < 0)
					throw new IllegalArgumentException();
				while ((line = reader.readLine()) != null) {
					String[] data = line.split(" ");
					if (data.length > 5) {
						System.out.println("Error: Something is wrong with your scenario file...");
						System.exit(2);
					}
					Flyable flyable = AircraftFactory.newAircraft(data[0], data[1],
									Integer.parseInt(data[2]), Integer.parseInt(data[3]),
									Integer.parseInt(data[4]));
					if (flyable != null)
						flyables.add(flyable);
				}
				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}
				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
				reader.close();
				printWriter.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Couldn't find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("Error: An error occurred while reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: Specify scenario file...");
		} catch (NumberFormatException e) {
			System.out.println("Error: Simulation count incompatible...");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: What am I supposed to do with these arguments?");
		}
	}
}
