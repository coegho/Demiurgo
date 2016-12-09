package es.usc.rai.coego.martin.demiurgo.universe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Action {
	protected long id;
	protected String code;
	protected String narration;
	protected WorldRoom room;
	protected List<User> witnesses;
	protected Date date;
	protected Status status;

	public Action(int i, WorldRoom room, String code, String prenarration, Status status) {
		this.id = -1;
		this.code = code;
		this.room = room;
		this.narration = prenarration;
		this.witnesses = new ArrayList<>(room.getUsers());
		this.date = new Date();
		this.status = status;
	}

	public Action(long id, WorldRoom room, String code, String narration, List<User> witnesses, Date date,
			Status status) {
		this.id = id;
		this.code = code;
		this.room = room;
		this.narration = narration;
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

	public WorldRoom getRoom() {
		return room;
	}

	public void setRoom(WorldRoom room) {
		this.room = room;
	}

	public List<User> getWitnesses() {
		return witnesses;
	}

	public void setWitnesses(List<User> witnesses) {
		this.witnesses = witnesses;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		FIX, READY, PUBLISHED;
	}
}
