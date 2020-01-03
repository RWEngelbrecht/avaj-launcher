package avaj.aircraft;

import avaj.simulator.*;
import avaj.simulator.interfaces.*;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	protected JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equalsIgnoreCase("sun")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 10,
				this.coordinates.getHeight() + 2
			);
			Simulator.printWriter.println("JetPlane#"+this.name+"("+this.id+"): IS THAT GIANT BALL OF BURNING GASS COMING RIGHT FOR U- Oh wait, that's the Sun.");
		} else if (weather.equalsIgnoreCase("rain")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 5,
				this.coordinates.getHeight()
			);
			Simulator.printWriter.println("JetPlane#"+this.name+"("+this.id+"): I fly between the raindrops.");
		} else if (weather.equalsIgnoreCase("fog")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 1,
				this.coordinates.getHeight()
			);
			Simulator.printWriter.println("JetPlane#"+this.name+"("+this.id+"): Ever see that movie The Fog? Not a good time?");
		} else if (weather.equalsIgnoreCase("snow")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 7
			);
			Simulator.printWriter.println("JetPlane#"+this.name+"("+this.id+"): Oh what fun it is to fly in a dual-jet metal deathtrap!");
		}
		if (this.coordinates.getHeight() <= 0) {
			Simulator.printWriter.println("JetPlane#"+this.name+"("+this.id+") landing.");
			this.weatherTower.unregister(this);
			Simulator.printWriter.println("Tower says: JetPlane#"+this.name+"("+this.id+") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.printWriter.println("Tower says: JetPlane#"+this.name+"("+this.id+") registered to weather tower.");
	}
}
