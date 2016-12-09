package es.usc.rai.coego.martin.demiurgo.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecuteCodeResponse {
	private ResponseStatus status;
	private JsonAction action;
	private int errorStartIndex;
	
	public ResponseStatus getStatus() {
		return status;
	}
	
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	
	public JsonAction getAction() {
		return action;
	}
	
	public void setAction(JsonAction action) {
		this.action = action;
	}
	
	public int getErrorStartIndex() {
		return errorStartIndex;
	}
	
	public void setErrorStartIndex(int errorStartIndex) {
		this.errorStartIndex = errorStartIndex;
	}
}
