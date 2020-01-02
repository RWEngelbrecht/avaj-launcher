package simulator;

import aircraft.Coordinates;
import weather.WeatherProvider;

public class WeatherTower extends Tower{
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	private void changeWeather() {
		
	}
}
