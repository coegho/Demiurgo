package es.usc.rai.coego.martin.demiurgo.database;

import java.util.Map;

public class WorldsConfig {
	private Map<String, WorldDBData> worlds;
	
	public Map<String, WorldDBData> getWorlds() {
		return worlds;
	}
	
	public void setWorlds(Map<String, WorldDBData> worlds) {
		this.worlds = worlds;
	}
}
