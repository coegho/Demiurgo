package es.usc.rai.coego.martin.demiurgo.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class ArgumentMismatchException extends DemiurgoException {
	
	private List<String> pa;
	private List<String> ra;

	public ArgumentMismatchException(int line, int column, int i, List<ValueInterface> providedArgs, List<ValueInterface> requiredArgs) {
		super("Arguments doesn't match", line, column, i);
		pa = providedArgs.stream().map(a -> a.getTypeName()).collect(Collectors.toList());
		ra = requiredArgs.stream().map(a -> a.getTypeName()).collect(Collectors.toList());
	}
	
	@Override
	public String getMessage() {
		return "Arguments doesn't match: "+ pa + " != "+ ra;
	}
}