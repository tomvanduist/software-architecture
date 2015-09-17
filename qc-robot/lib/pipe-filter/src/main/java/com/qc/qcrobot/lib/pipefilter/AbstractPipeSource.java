package com.qc.qcrobot.lib.pipefilter;

public abstract class AbstractPipeSource extends AbstractPipeFilter implements PipeSourceInterface {

	public <T> void read(T input) throws PipeInputTypeException {
		// no-op
	}
}
