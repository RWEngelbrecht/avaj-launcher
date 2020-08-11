package avaj.simulator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import avaj.simulator.interfaces.*;

public class Tower {
	private CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		if (observers.size() >= 0) {
			for (Flyable flyable : observers) {
				flyable.updateConditions();
			}
		}
	}
}

