package avaj.aircraft;

import avaj.simulator.interfaces.*;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		if (type.equalsIgnoreCase("Helicopter")) {
			//instantiate coordinates
// System.out.println("is Helicopter");
			Coordinates coordinates = new Coordinates(longitude, latitude, height);
			//instantiate aircraft
			return (new Helicopter(name, coordinates));
		} else if (type.equalsIgnoreCase("JetPlane")) {
// System.out.println("is jetplane");
			Coordinates coordinates = new Coordinates(longitude, latitude, height);
			return (new JetPlane(name, coordinates));
		}
		else if (type.equalsIgnoreCase("Baloon")) {
// System.out.println("is baloon");
			Coordinates coordinates = new Coordinates(longitude, latitude, height);
			return (new Baloon(name, coordinates));
		}
		return (null);
	}
}
