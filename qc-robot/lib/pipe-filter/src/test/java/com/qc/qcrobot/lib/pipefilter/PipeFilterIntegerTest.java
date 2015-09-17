package com.qc.qcrobot.lib.pipefilter;

public class PipeFilterIntegerTest extends AbstractPipeFilter {

	public <T> void read(T input) throws PipeInputTypeException, PipeMissingSinkException {
		Integer iInput = null;
		
		try {
			iInput = (Integer) input;
		} catch (Exception e) {
			throw new PipeInputTypeException();
		}
		
		this.write(++iInput);
	}
}
