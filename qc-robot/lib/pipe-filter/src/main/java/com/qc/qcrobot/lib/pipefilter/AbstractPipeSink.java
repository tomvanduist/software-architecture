package com.qc.qcrobot.lib.pipefilter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Extend this class to implement a PipeSink.
 * 
 *  @param <I> Input type
 */
public abstract class AbstractPipeSink<I> extends Thread implements InterfacePipe<I> {

	// Input queue
	protected Queue<I> queue = new LinkedList<I>();
	
	
	/**
	 * Implement this method to process the input as the last filter in the chain.
	 * 
	 * @param input Input data to be processed.
	 */
	protected abstract void process(I input);
	
	
	/**
	 * {@inheritDoc}
	 */
	protected I read() {
		if ( this.queue != null && !this.queue.isEmpty() )  {
			return this.queue.remove();
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void write(I input) {
		if ( this.queue != null ) {
			this.queue.add(input);
		}
	}
	
	/**
	 * Call process with data written to this filter as input.
	 */
	public void run() {
		while ( this.isAlive() ) {
			I input = this.read();
			if ( input != null ) {
				this.process(input);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public synchronized void begin() {
		super.start();
	}

	/**
	 * {@inheritDoc}
	 */
	public void end() {
		super.interrupt();
	}
}
