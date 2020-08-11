package avaj.weather;

import avaj.aircraft.Coordinates;
import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private String[] weather = {"sun", "snow", "rain", "fog"};
	private Random rnd = new Random();
	private WeatherProvider() {

	}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int height = coordinates.getHeight();
		// int latidude = coordinates.getLatitude();
		// int longitude = coordinates.getLongitude();

		if (height <= 100 && height >= 75)
			return (weather[0]);
		else if (height < 75 && height >= 35) {
			if ((rnd.nextInt() % 3) == 0)
				return (weather[2]);
			else if ((rnd.nextInt() % 2) == 0)
				return (weather[1]);
			return (weather[0]);
		}
		return (weather[rnd.nextInt(4)]);
	}
}
