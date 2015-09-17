package com.qc.qcrobot.lib.pipefilter;

public class PipeSinkTest extends AbstractPipeSink {

	public String outputVar;

	public void read(String input) {
		this.outputVar = input;
	}

}
