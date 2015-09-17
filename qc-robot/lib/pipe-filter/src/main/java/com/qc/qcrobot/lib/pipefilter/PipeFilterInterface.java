package com.qc.qcrobot.lib.pipefilter;

public interface PipeFilterInterface {
	
	public <T> void read(T input) throws PipeInputTypeException, PipeMissingSinkException;
	
	public <T> void write(T output) throws PipeInputTypeException, PipeMissingSinkException;
	
	public PipeFilterInterface connect(PipeFilterInterface output) throws PipeSinkConnectionException;
}
