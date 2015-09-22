package com.qc.qcrobot.lib.pipefilter;

/**
 * @param <T>
 * 
 * An example PipeSource used for UnitTesting.
 * Simply writes some input object which is set on construction as output.
 */
public class PipeSourceTest extends AbstractPipeSource<String> {

	private String input;

	
	public PipeSourceTest(String input, InterfacePipe<String> output) {
		super(output);
		this.input = input;
	}


	@Override
	protected String read() {
		return input;
	}
}
