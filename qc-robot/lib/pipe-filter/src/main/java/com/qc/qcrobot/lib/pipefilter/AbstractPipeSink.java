package com.qc.qcrobot.lib.pipefilter;

public abstract class AbstractPipeSink extends AbstractPipeFilter implements PipeSinkInterface {


	
	public PipeFilterInterface connect(PipeFilterInterface output) throws Exception {
		throw new Exception("com.qc.qcrobot.lib.pipefilter.abstractpipesink: A sink should be the last filter in the pipe.");
	}

	
	public void write(String output) {
		
	}
}
