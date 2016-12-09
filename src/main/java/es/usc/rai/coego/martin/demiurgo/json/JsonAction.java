package es.usc.rai.coego.martin.demiurgo.json;

import java.util.List;

public class JsonAction {
	private long id;
	private String code;
	private String narration;
	private String room;
	private List<String> witnesses;
	private String date;
	private String status;
	
	public JsonAction() {
	}
	
	public JsonAction(long id, String code, String narration, String room, List<String> witnesses, String date, String status) {
		super();
		this.id = id;
		this.code = code;
		this.narration = narration;
		this.room = room;
		this.witnesses = witnesses;
		this.date = date;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public List<String> getWitnesses() {
		return witnesses;
	}

	public void setWitnesses(List<String> witnesses) {
		this.witnesses = witnesses;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
