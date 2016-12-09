package es.usc.rai.coego.martin.demiurgo.parsing;

import java.util.ArrayList;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.DemiurgoException;

public class ErrorHandler {

	protected List<DemiurgoException> errors;

	public ErrorHandler() {
		errors = new ArrayList<>();
	}

	public void notifyError(DemiurgoException ex) {
		errors.add(ex);
	}

	public List<DemiurgoException> getErrors() {
		return errors;
	}

	public boolean hasErrors() {
		return errors.size() > 0;
	}
}
