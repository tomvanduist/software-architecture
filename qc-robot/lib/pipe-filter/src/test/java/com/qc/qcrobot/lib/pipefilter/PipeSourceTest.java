package com.qc.qcrobot.lib.pipefilter;

/**
 * @param <T>
 * 
 * An example PipeSource used for UnitTesting.
 * Simply writes some input object which is set on construction as output.
 */
public class PipeSourceTest extends AbstractPipeSource<String> {

	

	public PipeSourceTest(InterfacePipe<String> output) {
		super(output);
	}


	@Override
	protected String read() {
		return (String) "Hoi";
	}

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
