package demiurgo;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

	protected List<String> errors;
	
	public ErrorHandler() {
		errors = new ArrayList<>();
	}

	public void notifyError(Exception ex) {
		errors.add(ex.getMessage());
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public boolean hasErrors() {
		return errors.size() > 0;
	}
}
