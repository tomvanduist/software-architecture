package com.qc.qcrobot.lib.pipefilter;

/**
 * An example PipeSink used for UnitTesting.
 * Simply stores the input in a public property.
 */
public class PipeSinkTest extends AbstractPipeSink<String> {
	
	public String outputString;

	
	@Override
	public void process(String input) {
		this.outputString = input;
	}
}
