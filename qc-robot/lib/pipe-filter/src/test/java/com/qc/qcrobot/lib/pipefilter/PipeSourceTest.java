package com.qc.qcrobot.lib.pipefilter;

public class PipeSourceTest extends AbstractPipeSource {

	private String input;
	
	
	public PipeSourceTest(String input) {
		super();
		this.input = input;
	}

	public void start() {
		this.write(this.input);
	}
}
