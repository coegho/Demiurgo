package es.usc.rai.coego.martin.demiurgo.values;

import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;

public interface ClassTyped {
	DemiurgoClass getClassType();

	void setClassType(DemiurgoClass cl);
}
