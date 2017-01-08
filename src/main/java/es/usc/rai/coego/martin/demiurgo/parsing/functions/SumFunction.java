package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ReturnValueTypes;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class SumFunction extends BuiltinFunction {

	public SumFunction() {
		super();
		addArgument("list", ListValue.defaultValue(ReturnValueTypes.INT, 1));
		setReturnArgument("sum", IntegerValue.defaultValue());
	}
	
	@Override
	public void execute(Scope scope) {
		try {
			ListValue list = ListValue.defaultValue();
		
			list.assign(scope.getVariable("list"));
		
		
			ValueInterface sum = scope.getVariable("sum");
			
			int output = 0;
			
			for(ValueInterface i : list.getValue()) {
				output += ((IntegerValue)i).getValue();
			}
			sum.assign(new IntegerValue(output));
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}

}
