package com.qc.qcrobot.lib.pipefilter;

/**
 * Extend this class to implement a PipeSource
 * 
 * @param <O> Output type
 */
public abstract class AbstractPipeSource<O> extends Thread implements InterfacePipe<O> {

	// Output to write generated input
	protected InterfacePipe<O> output;
	
	protected volatile boolean running = false;
	
	
	/**
	 * Initialize with next filter in the chain.
	 * 
	 * @param output Output filter to write handled input to.
	 */
	public AbstractPipeSource(InterfacePipe<O> output) {
		this.output = output;
	}	
	
	
	/**
	 * Override and implement this method to start propagating data trough the chain.
	 * 
	 * @return Output to be handled by the first filter.
	 */
	protected abstract O read();
	
	
	/**
	 * Write data from calling read() to the output filter.
	 */
	public void run() {
		while ( this.running && this.isAlive() && this.output != null ) {
			this.output.write(this.read());
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public synchronized void startPipe() throws PipeMissingSinkException {
		this.running = true;
		super.start();
		
		if ( this.output != null ) {
			this.output.startPipe();
		} else {
			throw new PipeMissingSinkException();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void joinPipe() throws InterruptedException {
		if ( this.output != null ) {
			this.output.joinPipe();
		}
		
		this.join();
	}


	/**
	 * {@inheritDoc}
	 */
	public void stopPipe() {
		if ( this.output != null ) {
			this.output.stopPipe();
		}
		
		this.running = false;
		super.interrupt();
	}

	/**
	 * no-op; a source should generate the input
	 * 
	 * @throws PipeSourceInputException 
	 */
	public void write(O input) {
	}
}
