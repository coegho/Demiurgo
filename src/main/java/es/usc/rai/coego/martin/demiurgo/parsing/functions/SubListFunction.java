package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class SubListFunction extends BuiltinFunction {

	public SubListFunction() {
		super();
		addArgument("list", ListValue.defaultValue());
		addArgument("start", IntegerValue.defaultValue());
		addArgument("end", IntegerValue.defaultValue());
		setReturnArgument("sl", ListValue.defaultValue());
	}
	
	@Override
	public void execute(Scope scope) {
		try {
			ListValue list = ListValue.defaultValue();
			list.assign(scope.getVariable("list"));
			
			IntegerValue start = IntegerValue.defaultValue();
			start.assign(scope.getVariable("start"));
			
			IntegerValue end = IntegerValue.defaultValue();
			end.assign(scope.getVariable("end"));
			
			ValueInterface sl = scope.getVariable("sl");
			
			sl.assign(new ListValue(list.getValue().subList(start.getValue(), end.getValue())));
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}

}
