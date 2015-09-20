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
	 */
	public void begin() throws PipeMissingSinkException;
	
	/**
	 * End operations.
	 */
	public void end();
}
