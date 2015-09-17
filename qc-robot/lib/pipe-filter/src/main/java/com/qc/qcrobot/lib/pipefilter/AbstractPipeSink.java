package com.qc.qcrobot.lib.pipefilter;

public abstract class AbstractPipeSink extends AbstractPipeFilter implements PipeSinkInterface {

	
	public PipeFilterInterface connect(PipeFilterInterface output) throws PipeSinkConnectionException {
		throw new PipeSinkConnectionException();
	}

	public <T> void write(T output)  throws PipeInputTypeException, PipeMissingSinkException {
		// no-op
	}
}
