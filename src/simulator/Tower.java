package simulator;

import java.util.*;
import simulator.interfaces.Flyable;


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

