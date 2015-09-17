package com.qc.qcrobot.lib.pipefilter;

/**
 * An example PipeSink used for UnitTesting.
 * Simply stores the input in a public property.
 */
public class PipeSinkTest extends AbstractPipeSink {

	public String outputString;
	public Integer outputInt;

	public <T> void read(T input) {
		if ( input instanceof String ) {
			this.outputString = (String) input;
		} if ( input instanceof Integer ) {
			this.outputInt = (Integer) input;
		}
	}

}
