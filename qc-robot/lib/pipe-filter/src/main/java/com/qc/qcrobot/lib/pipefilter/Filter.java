package com.qc.qcrobot.lib.pipefilter;

public interface Filter {
	
	public String perform(String input);
	
	public String getOutput();
}
