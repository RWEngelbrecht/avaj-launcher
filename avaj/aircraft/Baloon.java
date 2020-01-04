package avaj.aircraft;

import avaj.simulator.*;
import avaj.simulator.interfaces.*;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
System.out.printf("Baloon %s conditions updated  at longitude %d  latitude %d   height %d %n", this.name,this.coordinates.getLongitude(),this.coordinates.getLatitude(), this.coordinates.getHeight());
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equalsIgnoreCase("sun")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 2,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 4
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): Praise the sun!");
			System.out.println("Baloon#"+this.name+"("+this.id+"): Praise the sun!");
		} else if (weather.equalsIgnoreCase("rain")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 5
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): Raindrops keep falling on my head... Wait... *screams*");
			System.out.println("Baloon#"+this.name+"("+this.id+"): Raindrops keep falling on my head... Wait... *screams*");
		} else if (weather.equalsIgnoreCase("fog")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 3
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): You'd think the rotors would help clear this fog.");
			System.out.println("Baloon#"+this.name+"("+this.id+"): You'd think the rotors would help clear this fog.");
		} else if (weather.equalsIgnoreCase("snow")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 15
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): Staying frosty. As if we have a choice...");
			System.out.println("Baloon#"+this.name+"("+this.id+"): Staying frosty. As if we have a choice...");
		}
		if (this.coordinates.getHeight() <= 0) {
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+") landing.");
			this.weatherTower.unregister(this);
			Simulator.printWriter.println("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower.");
		}
System.out.printf("new long: %d%nnew lat: %d%nnew height: %d%n",this.coordinates.getLongitude(),this.coordinates.getLatitude(),this.coordinates.getHeight());
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.printWriter.println("Tower says: Baloon#"+this.name+"("+this.id+") registered to weather tower.");
	}
}
