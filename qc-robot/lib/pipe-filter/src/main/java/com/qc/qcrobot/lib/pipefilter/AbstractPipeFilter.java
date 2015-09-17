package com.qc.qcrobot.lib.pipefilter;

/**
 * Extend this class to implement a PipeFilter
 */
public abstract class AbstractPipeFilter implements PipeFilterInterface {

	protected PipeFilterInterface output;
	
	/**
	 * Connects an output filter as the next filter to receive the input.
	 */
	public PipeFilterInterface connect(PipeFilterInterface output) throws PipeSinkConnectionException {
		return this.output = output;
	}

	/**
	 * Writes the processed input as output to the next filter.
	 * 
	 * @param output Processed input to be propagated.
	 * 
	 * @throws PipeInputTypeException
	 * @throws PipeMissingSinkException
	 */
	protected <T> void write(T output) throws PipeInputTypeException, PipeMissingSinkException {
		if ( this.output != null ) {
			this.output.read(output);
		}
	}
}
