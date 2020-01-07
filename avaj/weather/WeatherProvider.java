package avaj.weather;

import avaj.aircraft.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private String[] weather = {"sun", "snow", "rain", "fog"};

	private WeatherProvider() {

	}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return (weatherProvider);
	}


//TODO: Find a way to use coordinates for weather production
	public String getCurrentWeather(Coordinates coordinates) {
		int height = coordinates.getHeight();
		// int latidude = coordinates.getLatitude();
		// int longitude = coordinates.getLongitude();

		if (height <= 100 && height >= 75)
			return (weather[0]);
		else if (height < 75 && height >= 55)
			return (weather[1]);
		else if (height < 55 && height >= 35)
			return (weather[2]);
		return (weather[3]);
	}
}
