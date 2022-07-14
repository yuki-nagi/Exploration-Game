package sercher;

import map.FirstRoom;
import object.GameObjectSouce;

public class Sercher {
	
	public void mebosi(GameObjectSouce GO) {
		GO.mebosiEvent();
	}
	
	public void Break(GameObjectSouce GO) {
		GO.breakEvent();
	}
	
	public void look(GameObjectSouce GO) {
		GO.lookEvent();
	}
	
	public void look(FirstRoom fr) {
		fr.lookEvent();
	}

}
