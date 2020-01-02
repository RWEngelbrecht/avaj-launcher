package aircraft;

import simulator.WeatherTower;
import simulator.interfaces.Flyable;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equalsIgnoreCase("sun")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 2,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 4
			);
			System.out.println("Baloon#"+this.name+"("+this.id+"): Praise the sun!");
		} else if (weather.equalsIgnoreCase("rain")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 5
			);
			System.out.println("Baloon#"+this.name+"("+this.id+"): Raindrops keep falling on my head... Wait... *screams*");
		} else if (weather.equalsIgnoreCase("fog")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 3
			);
			System.out.println("Baloon#"+this.name+"("+this.id+"): You'd think the rotors would help clear this fog.");
		} else if (weather.equalsIgnoreCase("snow")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 15
			);
			System.out.println("Baloon#"+this.name+"("+this.id+"): Staying frosty. As if we have a choice...");
		}
		if (this.coordinates.getHeight() <= 0) {
			System.out.println("Baloon#"+this.name+"("+this.id+") landing.");
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#"+this.name+"("+this.id+") registered to weather tower.");
	}
}