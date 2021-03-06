package es.usc.rai.coego.martin.demiurgo.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecuteCodeRequest {
	private String path;
	private String code;
	private boolean createAction;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public boolean isCreateAction() {
		return createAction;
	}
	
	public void setCreateAction(boolean createAction) {
		this.createAction = createAction;
	}
}
