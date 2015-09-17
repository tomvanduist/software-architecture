package com.qc.qcrobot.lib.pipefilter;


public abstract class AbstractPipeFilter implements PipeFilterInterface {

	protected PipeFilterInterface output;
	
	public PipeFilterInterface connect(PipeFilterInterface output) throws Exception {
		return this.output = output;
	}

	public void write(String output) {
		if ( this.output != null ) {
			this.output.read(output);
		}
	}
}
