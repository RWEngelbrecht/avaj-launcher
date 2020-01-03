package avaj.simulator;

import java.util.*;
import avaj.simulator.interfaces.*;


public class Tower {
	private static List<Flyable> crafts = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		crafts.add(flyable);
	}

	public void unregister(Flyable flyable) {
		crafts.remove(flyable);
	}

	protected void conditionsChanged() {

	}
}

