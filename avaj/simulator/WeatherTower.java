package avaj.simulator;

import avaj.aircraft.*;
import avaj.weather.*;

public class WeatherTower extends Tower{
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	protected void changeWeather() {

	}
}
