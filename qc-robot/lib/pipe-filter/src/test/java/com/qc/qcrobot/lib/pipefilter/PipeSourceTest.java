package com.qc.qcrobot.lib.pipefilter;

/**
 * @author FT_5
 * @company Quality Control
 * @date Sep 17, 2015
 * 
 * @param <T>
 * 
 * An example PipeSource used for UnitTesting.
 * Simply writes some input object which is set on construction as output.
 */
public class PipeSourceTest<T> extends AbstractPipeSource {

	private T input;
	
	public PipeSourceTest() {
		super();
	}
	
	public PipeSourceTest(T input) {
		super();
		this.input = input;
	}

	public void start()  throws PipeInputTypeException, PipeMissingSinkException {
		this.write(this.input);
	}
}
