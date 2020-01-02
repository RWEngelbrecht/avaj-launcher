package aircraft;

import simulator.interfaces.Flyable;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		if (type.equalsIgnoreCase("Helicopter")) {
			//instantiate coordinates
			Coordinates coordinates = new Coordinates(longitude, latitude, height);
			//instantiate aircraft
			return (new Helicopter(name, coordinates));
		}
		return (null);
	}
}
