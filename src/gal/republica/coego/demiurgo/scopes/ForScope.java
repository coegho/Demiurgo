package gal.republica.coego.demiurgo.scopes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gal.republica.coego.demiurgo.values.IReturnValue;
import gal.republica.coego.demiurgo.values.ListValue;
import gal.republica.coego.demiurgo.values.StringValue;

/**
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class ForScope extends LoopScope {
	protected String auxVar;
	protected List<IReturnValue> originValues;

	
	public ForScope(String auxVar, ListValue origin, Scope parent) {
		super(parent);
		variables = new HashMap<>();
		this.auxVar = auxVar;
		originValues = new ArrayList<>();
		for(IReturnValue v : origin.getValue()) {
			originValues.add(v);
		}
	}
	
	public ForScope(String auxVar, StringValue origin, Scope parent) {
		super(parent);
		variables = new HashMap<>();
		this.auxVar = auxVar;
		originValues = new ArrayList<>();
		for(char c : origin.getValue().toCharArray()) {
			String cc = Character.toString(c);
			originValues.add(new StringValue(cc));
		}
	}
	
	
	public String getAuxVar() {
		return auxVar;
	}
	
	public void setAuxVar(String auxVar) {
		this.auxVar = auxVar;
	}
	
	public List<IReturnValue> getOriginValues() {
		return originValues;
	}
}
