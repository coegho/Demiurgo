package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import java.util.ArrayList;
import java.util.List;

import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ReturnValueTypes;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ZerosFunction extends BuiltinFunction {

	public ZerosFunction() {
		super();
		addArgument("num", IntegerValue.defaultValue());
		setReturnArgument("list", ListValue.defaultValue(ReturnValueTypes.INT, 1));
	}
	
	@Override
	public void execute(Scope scope) {
		try {
			IntegerValue num = IntegerValue.defaultValue();
			num.assign(scope.getVariable("num"));
			
			ValueInterface list = scope.getVariable("list");
			
			List<ValueInterface> output = new ArrayList<>();
			
			for(int i=0; i<num.getValue(); i++) {
				output.add(new IntegerValue(0));
			}
			
			list.assign(new ListValue(output));
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}

}
