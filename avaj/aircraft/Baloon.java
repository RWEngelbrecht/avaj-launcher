package avaj.aircraft;

import avaj.simulator.*;
import avaj.simulator.interfaces.*;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equalsIgnoreCase("sun") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 2,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 4
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): I could easily do this in less than 80 days!");
			// System.out.println("Baloon#"+this.name+"("+this.id+"): I could easily do this in less than 80 days!!");
		} else if (weather.equalsIgnoreCase("rain") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 5
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): The top of this balloon is 100 degrees Centigrade... Time to make some tea.");
		} else if (weather.equalsIgnoreCase("fog") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 3
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): Hope I can still see any obstacles at least 30 seconds before colission, else I'm screwed.");
		} else if (weather.equalsIgnoreCase("snow") && this.coordinates.getHeight() > 0) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 15
			);
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+"): Staying frosty. As if we have a choice...");
		}
		if (this.coordinates.getHeight() <= 0) {
			Simulator.printWriter.println("Baloon#"+this.name+"("+this.id+") landing.");
			this.weatherTower.unregister(this);
			Simulator.printWriter.println("Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.printWriter.println("Tower says: Baloon#"+this.name+"("+this.id+") registered to weather tower.");
	}
}
