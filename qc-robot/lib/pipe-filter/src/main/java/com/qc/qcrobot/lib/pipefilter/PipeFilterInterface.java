package com.qc.qcrobot.lib.pipefilter;

public interface PipeFilterInterface {
	
	public void read(String input);
	
	public void write(String output);
	
	public PipeFilterInterface connect(PipeFilterInterface output) throws Exception;
}
