package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;

@FunctionalInterface
public interface BinaryFunction {
	ValueInterface apply(ValueInterface l, ValueInterface r) throws IllegalOperationException;
}
