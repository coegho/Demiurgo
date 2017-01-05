package es.usc.rai.coego.martin.demiurgo.universe;

import es.usc.rai.coego.martin.demiurgo.json.JsonWitness;

public class Witness {
	protected User user;
	protected String decision;
	
	public Witness(User witness, String decision) {
		this.user = witness;
		this.decision = decision;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getDecision() {
		return decision;
	}
	
	public void setDecision(String decision) {
		this.decision = decision;
	}

	public JsonWitness toJson() {
		return new JsonWitness(user.getUsername(), decision);
	}
}
