package avaj.simulator.interfaces;

import avaj.simulator.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}
