package com.qc.qcrobot.lib.pipefilter;

/**
 * 
 */
class PipeInputTypeException extends Exception {
	
	private static final long serialVersionUID = 1110001;
	
	public PipeInputTypeException() {
		super("com.qc.qcrobot.lib.pipefilter: Unexpected input type.");
	}
}

/**
 * 
 */
class PipeMissingSinkException extends Exception {
	
	private static final long serialVersionUID = 1110002;
	
	public PipeMissingSinkException() {
		super("com.qc.qcrobot.lib.pipefilter: PipeSink is missing. A Pipe structure needs to end with a Sink.");
	}
}

/**
 * 
 */
class PipeSinkConnectionException extends Exception {
	
	private static final long serialVersionUID = 1110003;
	
	public PipeSinkConnectionException() {
		super("com.qc.qcrobot.lib.pipefilter: Cannot connect other filters after a Sink, a Sink should be the last link.");
	}
}
