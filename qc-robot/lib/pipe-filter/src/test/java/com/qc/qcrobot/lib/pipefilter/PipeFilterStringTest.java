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
	public void filter(String input, InterfacePipe<String> output) {
		output.write(input);
	}
}
