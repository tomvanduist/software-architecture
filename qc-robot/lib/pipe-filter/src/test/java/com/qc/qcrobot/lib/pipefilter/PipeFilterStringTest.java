package com.qc.qcrobot.lib.pipefilter;

public class PipeFilterStringTest extends AbstractPipeFilter {

	public <T> void read(T input) throws PipeInputTypeException, PipeMissingSinkException {
		String sInput = null;
		
		try {
			sInput = (String) input;
		} catch (Exception e) {
			throw new PipeInputTypeException();
		}
		
		this.write(sInput.replace('p', 'c'));
	}
}
