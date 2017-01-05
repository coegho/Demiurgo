package es.usc.rai.coego.martin.demiurgo.universe;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.json.JsonAction;

public class Action implements Comparable<Action> {
	protected long id;
	protected String narration;
	protected DemiurgoRoom room;
	protected List<User> witnesses;
	protected Date date;
	protected boolean published;

	public Action(int i, DemiurgoRoom room, String prenarration) {
		this.id = -1;
		this.room = room;
		this.narration = prenarration;
		this.witnesses = new ArrayList<>(room.getUsers());
		this.date = new Date();
		this.published = false;
	}
	
	public Action(DemiurgoRoom room, String prenarration, List<User> witnesses) {
		this.id = -1;
		this.room = room;
		this.narration = prenarration;
		this.witnesses = witnesses;
		this.date = new Date();
		this.published = false;
	}

	public Action(long id, DemiurgoRoom room, String narration, List<User> witnesses, Date date, boolean published) {
		this.id = id;
		this.room = room;
		this.narration = narration;
		this.witnesses = witnesses;
		this.date = date;
		this.published = published;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public DemiurgoRoom getRoom() {
		return room;
	}

	public void setRoom(DemiurgoRoom room) {
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
	
	public boolean isPublished() {
		return published;
	}
	
	public void setPublished(boolean published) {
		this.published = published;
	}
	
	public JsonAction toJson() {
		List<String> witnesses = new ArrayList<>();
		for (User u : getWitnesses()) {
			witnesses.add(u.getUsername());
		}
		DateFormat df = DateFormat.getInstance();
		return new JsonAction(getId(), getNarration(), getRoom().getLongPath(),
				witnesses, df.format(getDate()), isPublished());
	}

	@Override
	public int compareTo(Action o) {
		if(o.getDate().getTime() > this.getDate().getTime()) {
			return -1;
		}
		if(o.getDate().getTime() < this.getDate().getTime()) {
			return 1;
		}
		return 0;
	}
}
