package com.qc.qcrobot.lib.pipefilter;

/**
 * @author FT_5
 * @company Quality Control
 * @date Sep 17, 2015
 * 
 * An example PipeFilter used for UnitTesting.
 * Simply processes string input and replaces all occurrences of 'p' with 'c'.
 */
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
