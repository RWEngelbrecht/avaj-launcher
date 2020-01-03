package avaj.simulator;

import java.io.*;
import java.util.*;
import avaj.simulator.interfaces.*;
import avaj.simulator.interfaces.Flyable;
import avaj.aircraft.*;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	// public static FileWriter fileWriter = new FileWriter("./simulation.txt");
	public static PrintWriter printWriter = null;

	public static void main(String[] arg) throws InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
			String line = reader.readLine();
			File simulation = new File("./simulation.txt");
			printWriter = new PrintWriter(simulation);

			if (line != null) {
				// weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Invalid simulation count " + simulations);
					System.exit(1);
				}
				while ((line = reader.readLine()) != null) {
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
									Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
									Integer.parseInt(line.split(" ")[4]));
					if (flyable != null)
						flyables.add(flyable);
				}

				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
					// System.out.println("wtf is going on");
				}

				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
				reader.close();
				printWriter.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file " + arg[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + arg[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Specify simulation file");
		}
	}
}
