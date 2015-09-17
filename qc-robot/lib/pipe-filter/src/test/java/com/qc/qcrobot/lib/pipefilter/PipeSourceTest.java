package com.qc.qcrobot.lib.pipefilter;

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
