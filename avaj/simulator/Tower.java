package avaj.simulator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import avaj.simulator.interfaces.*;

public class Tower {
	private CopyOnWriteArrayList<Flyable> crafts = new CopyOnWriteArrayList<Flyable>();

	public void register(Flyable flyable) {
		crafts.add(flyable);
	}

	public void unregister(Flyable flyable) {
		crafts.remove(flyable);
	}

	protected void conditionsChanged() {
		if (crafts.size() >= 0) {
			for (Flyable flyable : crafts) {
				flyable.updateConditions();
			}
		}
	}
}

