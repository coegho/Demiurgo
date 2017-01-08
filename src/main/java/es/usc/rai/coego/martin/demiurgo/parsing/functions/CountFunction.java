package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class CountFunction extends BuiltinFunction {

	public CountFunction() {
		super();
		addArgument("list", ListValue.defaultValue());
		setReturnArgument("len", IntegerValue.defaultValue());
	}
	
	@Override
	public void execute(Scope scope) {
		try {
			ListValue list = ListValue.defaultValue();
			list.assign(scope.getVariable("list"));
			
			ValueInterface l = scope.getVariable("len");
	
			l.assign(new IntegerValue(list.getValue().size()));
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}

}
