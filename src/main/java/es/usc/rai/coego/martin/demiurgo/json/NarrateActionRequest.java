package es.usc.rai.coego.martin.demiurgo.json;

public class NarrateActionRequest {
	private long id;
	private String room;
	private String narration;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getNarration() {
		return narration;
	}
	
	public void setNarration(String narration) {
		this.narration = narration;
	}
}
