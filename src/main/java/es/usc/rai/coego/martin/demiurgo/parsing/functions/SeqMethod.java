package es.usc.rai.coego.martin.demiurgo.parsing.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.ReturnValueTypes;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class SeqMethod extends BuiltinMethod {

	
	public SeqMethod() {
		super();
		addArgument("start", IntegerValue.defaultValue());
		addArgument("end", IntegerValue.defaultValue());
		setReturnArgument("l", ListValue.defaultValue(ReturnValueTypes.INT, 1));
	}

	@Override
	public void execute(Scope scope) {
		IntegerValue start = IntegerValue.defaultValue();
		start.assign(scope.getVariable("start"));
		
		IntegerValue end = IntegerValue.defaultValue();
		end.assign(scope.getVariable("end"));
		
		ValueInterface l = scope.getVariable("l");
		
		List<ValueInterface> output = new ArrayList<>();
		
		for(int i : IntStream.rangeClosed(start.getValue(), end.getValue()).boxed().collect(Collectors.toList())) {
			output.add(new IntegerValue(i));
		}
		l.assign(new ListValue(output));
	}

}
