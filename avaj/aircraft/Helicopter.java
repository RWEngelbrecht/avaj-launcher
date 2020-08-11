package avaj.aircraft;

import avaj.simulator.*;
import avaj.simulator.interfaces.*;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equalsIgnoreCase("sun") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 10,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 2
			);
			Simulator.printWriter.println("Helicopter#"+this.name+"("+this.id+"): Praise the sun!");
		} else if (weather.equalsIgnoreCase("rain") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 5,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight()
			);
			Simulator.printWriter.println("Helicopter#"+this.name+"("+this.id+"): Raindrops keep falling on my head... Wait... *screams*");
		} else if (weather.equalsIgnoreCase("fog") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 1,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight()
			);
			Simulator.printWriter.println("Helicopter#"+this.name+"("+this.id+"): You'd think the rotors would help clear this fog.");
		} else if (weather.equalsIgnoreCase("snow") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 12
			);
			Simulator.printWriter.println("Helicopter#"+this.name+"("+this.id+"): Oh no! I'm seeing white spots!");
		}
		if (this.coordinates.getHeight() <= 0) {
			Simulator.printWriter.println("Helicopter#"+this.name+"("+this.id+") landing.");
			this.weatherTower.unregister(this);
			Simulator.printWriter.println("Tower says: Helicopter#"+this.name+"("+this.id+") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.printWriter.println("Tower says: Helicopter#"+this.name+"("+this.id+") registered to weather tower.");
	}
}
