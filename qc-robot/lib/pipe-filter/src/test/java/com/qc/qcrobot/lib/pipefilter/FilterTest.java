package com.qc.qcrobot.lib.pipefilter;

public class FilterTest implements Filter {

	private String start;
	private String output;
	
	public FilterTest(String start) {
		super();
		this.start = start;
	}


	@Override
	public String perform(String input) {
		if (input == null) {
			input = this.start;
		}
		return this.output = input.concat(input);
	}


	@Override
	public String getOutput() {
		return this.output;
	}

}
