package com.qc.qcrobot.lib.pipefilter;


/**
 * Thrown when the Pipeline does not contain a sink as the last filter.
 */
class PipeMissingSinkException extends Exception {
	
	private static final long serialVersionUID = 1110002;
	
	public PipeMissingSinkException() {
		super("com.qc.qcrobot.lib.pipefilter: PipeSink is missing. A Pipe structure needs to end with a Sink.");
	}
}
