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
	
	public volatile boolean running = false;
	
	
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
		if ( this.queue != null )  {
			return this.queue.poll();
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
		while ( this.running && this.isAlive() ) {
			I input = this.read();
			if ( input != null ) {
				this.process(input);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public synchronized void startPipe() {
		this.running = true;
		super.start();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void joinPipe() throws InterruptedException {
		this.join();
	}


	/**
	 * {@inheritDoc}
	 */
	public void stopPipe() {
		this.running = false;
		super.interrupt();
	}
}
