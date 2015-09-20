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
	 * Let input data be handled by the filter. The filter should write the handled data to the output.
	 */
	public void run() {
		while ( this.isAlive() ) {
			I input = this.read();
			if ( input != null ) {
				this.filter(input, output);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public synchronized void begin() throws PipeMissingSinkException {
		super.start();
		if ( this.output != null ) {
			this.output.begin();
		} else {
			throw new PipeMissingSinkException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void end() {
		if ( this.output != null ) {
			this.output.end();
		}
		super.interrupt();
	}
}
