package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;
import jersey.repackaged.com.google.common.collect.Lists;

public class ReverseFunction extends BuiltinFunction {
	public ReverseFunction() {
		super();
		addArgument("list", ListValue.defaultValue());
		setReturnArgument("reversed", ListValue.defaultValue());
	}
	
	@Override
	public void execute(Scope scope) {
		try {
			ListValue list = ListValue.defaultValue();
			list.assign(scope.getVariable("list"));
			
			ValueInterface reversed = scope.getVariable("reversed");
			
			 List<ValueInterface> output = (Lists.reverse(list.getValue()));
			 
			reversed.assign(new ListValue(output));
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}

}
