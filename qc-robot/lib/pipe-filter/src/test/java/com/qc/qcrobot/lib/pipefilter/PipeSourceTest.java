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


//	@Override
//	public synchronized void begin() throws PipeMissingSinkException {
//		super.run();
//	}
	
	

//	private T input;
//	
//	public PipeSourceTest() {
//		super();
//	}
//	
//	public PipeSourceTest(T input) {
//		super();
//		this.input = input;
//	}
//
//	public void start1()  throws PipeInputTypeException, PipeMissingSinkException {
//		this.write(this.input);
//	}
}
