package com.qc.qcrobot.lib.pipefilter;

/**
 * Extend this class to implement a PipeSource
 */
public abstract class AbstractPipeSource<O> extends Thread implements InterfacePipeSource<O> {

	protected InterfacePipe<O> output;
	
	public AbstractPipeSource(InterfacePipe<O> output) {
		this.output = output;
	}	
	
	
	
	public void run() {
		while ( this.isAlive() && this.output != null ) {
			this.output.write(this.read());
		}
	}
	
	
	
	protected abstract O read();
	
	@Override
	public void write(O input) {
		// no-op
	}
	
	public synchronized void start() {
		super.start();
		if ( this.output != null ) {
			this.output.start();
		}
	}

	@Override
	public void interrupt() {
		if ( this.output != null ) {
			this.output.interrupt();
		}
		super.interrupt();
	}

	
	
	


	
}
