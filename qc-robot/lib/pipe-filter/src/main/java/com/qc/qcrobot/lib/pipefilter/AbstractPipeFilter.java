package com.qc.qcrobot.lib.pipefilter;

public abstract class AbstractPipeFilter implements PipeFilterInterface {

	protected PipeFilterInterface output;
	
	public PipeFilterInterface connect(PipeFilterInterface output) throws PipeSinkConnectionException {
		return this.output = output;
	}

	public <T> void write(T output) throws PipeInputTypeException, PipeMissingSinkException {
		if ( this.output != null ) {
			this.output.read(output);
		}
	}
}
