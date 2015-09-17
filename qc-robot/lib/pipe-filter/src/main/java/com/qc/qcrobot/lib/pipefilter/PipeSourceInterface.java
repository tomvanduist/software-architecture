package com.qc.qcrobot.lib.pipefilter;

/**
 * PipeSourceInterface is the active filter and implements the start of the Pipe chain.
 */
public interface PipeSourceInterface extends PipeFilterInterface {
	
	/**
	 * Start producing input to be propagated trough the Pipeline.
	 * 
	 * @throws PipeInputTypeException
	 * @throws PipeMissingSinkException
	 */
	public void start() throws PipeInputTypeException, PipeMissingSinkException;
}
