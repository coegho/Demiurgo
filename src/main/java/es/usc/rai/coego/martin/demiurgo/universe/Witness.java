package es.usc.rai.coego.martin.demiurgo.universe;

public class Witness {
	protected User witness;
	protected String decision;
	
	public User getWitness() {
		return witness;
	}
	
	public void setWitness(User witness) {
		this.witness = witness;
	}
	
	public String getDecision() {
		return decision;
	}
	
	public void setDecision(String decision) {
		this.decision = decision;
	}
}
