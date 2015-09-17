package com.qc.qcrobot.lib.pipefilter;

/**
 * @author FT_5
 * @company Quality Control
 * @date Sep 17, 2015
 * 
 * Extend this class to implement a PipeSink.
 */
public abstract class AbstractPipeSink extends AbstractPipeFilter implements PipeSinkInterface {

	/**
	 * A Sink is the last chain and should not contain any output filter.
	 */
	public PipeFilterInterface connect(PipeFilterInterface output) throws PipeSinkConnectionException {
		throw new PipeSinkConnectionException();
	}

	/**
	 * Write does nothign as a Sink should have no output filter.
	 */
	protected <T> void write(T output)  throws PipeInputTypeException, PipeMissingSinkException {
		// no-op
	}
}
