package universe;

public class WorldRoom extends WorldContainer {
	protected String longName;

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}
	
	public String getShortName() {
		return longName.substring(longName.lastIndexOf('.'));
	}
}
