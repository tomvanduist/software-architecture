package com.qc.qcrobot.lib.pipefilter;

/**
 * Thrown when the filter input does not match the expected type.
 */
class PipeInputTypeException extends Exception {
	
	private static final long serialVersionUID = 1110001;
	
	public PipeInputTypeException() {
		super("com.qc.qcrobot.lib.pipefilter: Unexpected input type.");
	}
}

/**
 * Thrown when the Pipeline does not contain a sink as the last filter.
 */
class PipeMissingSinkException extends Exception {
	
	private static final long serialVersionUID = 1110002;
	
	public PipeMissingSinkException() {
		super("com.qc.qcrobot.lib.pipefilter: PipeSink is missing. A Pipe structure needs to end with a Sink.");
	}
}

/**
 * Thrown when a filter is added as a connction to a sink.
 * A sink should be the last filter, so it should not contain an output filter.
 */
class PipeSinkConnectionException extends Exception {
	
	private static final long serialVersionUID = 1110003;
	
	public PipeSinkConnectionException() {
		super("com.qc.qcrobot.lib.pipefilter: Cannot connect other filters after a Sink, a Sink should be the last link.");
	}
}
