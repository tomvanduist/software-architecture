package com.qc.qcrobot.lib.pipefilter;

/**
 * An example PipeFilter used for UnitTesting.
 * Simply processes string input and replaces all occurrences of 'p' with 'c'.
 */
public class PipeFilterStringTest extends AbstractPipeFilter<String, String> {

	public PipeFilterStringTest(InterfacePipe<String> output) {
		super(output);
	}

	@Override
	protected void filter(String input, InterfacePipe<String> output) {
		output.write(input);
	}

//	public <T> void read(T input) throws PipeInputTypeException, PipeMissingSinkException {
//		String sInput = null;
//		
//		try {
//			sInput = (String) input;
//		} catch (Exception e) {
//			throw new PipeInputTypeException();
//		}
//		
//		this.write(sInput.replace('p', 'c'));
//	}
}
