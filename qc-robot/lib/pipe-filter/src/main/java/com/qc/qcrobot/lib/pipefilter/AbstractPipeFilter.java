package com.qc.qcrobot.lib.pipefilter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Extend this class to implement a PipeFilter
 * 
 * @param <I> Input type
 * @param <O> Output type
 */
public abstract class AbstractPipeFilter<I, O> extends Thread implements InterfacePipe<I> {

	// Output to write handled input
	protected InterfacePipe<O> output;
	
	// Input queue
	protected Queue<I> queue = new LinkedList<I>();
	
	public volatile boolean running = false;
	
	
	/**
	 * Initialize with next filter in the chain.
	 * 
	 * @param output Output filter to write handled input to.
	 */
	public AbstractPipeFilter(InterfacePipe<O> output) {
		this.output = output;
	}

	
	/**
	 * Implement this method to handle the input and write it to the output.
	 * 
	 * @param input Input data to be handled.
	 * @param output Output filter to write the handled input to.
	 */
	protected abstract void filter(I input, InterfacePipe<O> output);
	
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
	 * Let input data be handled by the filter. The filter should write the handled data to the output.
	 */
	public void run() {
		while ( this.running && this.isAlive() ) {
			I input = this.read();
			if ( input != null ) {
				this.filter(input, output);
			}
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
}
