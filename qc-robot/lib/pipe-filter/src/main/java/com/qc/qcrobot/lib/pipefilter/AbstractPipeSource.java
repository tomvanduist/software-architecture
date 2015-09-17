package com.qc.qcrobot.lib.pipefilter;

/**
 * Extend this class to implement a PipeSource
 */
public abstract class AbstractPipeSource extends AbstractPipeFilter implements PipeSourceInterface {

	/**
	 * Read does nothing as a Source should not have an input filter.
	 * The source should generate the input that is propagated trough the Pipeline.
	 */
	public <T> void read(T input) throws PipeInputTypeException {
		// no-op
	}
}
