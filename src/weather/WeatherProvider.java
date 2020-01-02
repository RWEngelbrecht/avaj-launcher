package weather;

import aircraft.Coordinates;

public class WeatherProvider {
	private WeatherProvider weatherProvider = null;
	private String[] weather = {"sun", "snow", "rain", "fog"};

	private WeatherProvider() {

	}

	public WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int height = coordinates.getHeight();
		// int latidude = coordinates.getLatitude();
		// int longitude = coordinates.getLongitude();

		if (height <= 100 && height >= 90)
			return (weather[0]);
		else if (height < 90 && height >= 80)
			return (weather[1]);
		else if (height < 80 && height >= 70)
			return (weather[2]);
		return (weather[3]);
	}
}