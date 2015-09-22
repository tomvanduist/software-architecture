package com.qc.qcrobot.lib.pipefilter;

/**
 * Common interface for PipeFilter objects.
 * 
 * @param <I> Input type
 */
public interface InterfacePipe<I> extends Runnable {
	
	/**
	 * Write the input data to this filter.
	 * 
	 * @param input Filter input
	 */
	public void write(I input);
	
	/**
	 * Begin operations.
	 * 
	 * @throws PipeMissingSinkException
	 */
	public void startPipe() throws PipeMissingSinkException;
	
	/**
	 * Join threads
	 * 
	 * @throws InterruptedException
	 */
	public void joinPipe() throws InterruptedException;
	
	/**
	 * End operations.
	 */
	public void stopPipe();
}
