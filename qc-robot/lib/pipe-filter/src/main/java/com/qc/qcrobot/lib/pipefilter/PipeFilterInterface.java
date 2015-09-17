package com.qc.qcrobot.lib.pipefilter;

/**
 * The PipeFilterInterface is the base interface of the Pipe&Filter pattern pipeline.
 * Filters can be chained by connecting multiple PipeFilterPatterns in a list to form a Pipe.
 * A pipe has to start with an active filter, the PipeSource. The source will generate the input
 * to be propagated through the pipe. The pipe should end with a PipeSink which will end the chain.
 */
public interface PipeFilterInterface {
	
	/**
	 * Will be called by a filter to propagate the input to the next filter.
	 * 
	 * @param input The input to be modified and propagated.
	 * 
	 * @throws PipeInputTypeException
	 * @throws PipeMissingSinkException
	 */
	public <T> void read(T input) throws PipeInputTypeException, PipeMissingSinkException;
	
	/**
	 * Connect the next filter in the chain.
	 * 
	 * @param output
	 * @return PipeFilterInterface The filter passed through the @param output.
	 * 
	 * @throws PipeSinkConnectionException
	 */
	public PipeFilterInterface connect(PipeFilterInterface output) throws PipeSinkConnectionException;
}
