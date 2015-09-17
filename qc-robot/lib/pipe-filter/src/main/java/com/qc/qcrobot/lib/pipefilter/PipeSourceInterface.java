package com.qc.qcrobot.lib.pipefilter;

/**
 * @author FT_5
 * @company Quality Control
 * @date Sep 17, 2015
 * 
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
