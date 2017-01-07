package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;

@FunctionalInterface
public interface UnaryFunction {
	ValueInterface apply(ValueInterface v) throws IllegalOperationException;
}
