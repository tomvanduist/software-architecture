package com.qc.qcrobot.lib.pipefilter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Extend this class to implement a PipeFilter
 * @param <T>
 * @param <I>
 */
public abstract class AbstractPipeFilter<I, O> extends Thread implements InterfacePipeFilter<I, O> {

	protected InterfacePipe<O> output;
	
	protected Queue<I> queue = new LinkedList<I>();
	
	public AbstractPipeFilter(InterfacePipe<O> output) {
		this.output = output;
	}
	
	
	@Override
	public void write(I input) {
		if ( this.queue != null ) {
			this.queue.add(input);
		}
	}
	
	

	@Override
	public void run() {
		while ( this.isAlive() ) {
			I input = this.read();
			if ( input != null ) {
				this.filter(input, output);
			}
		}
	}
	
	protected I read() {
		if ( this.queue != null && !this.queue.isEmpty() )  {
			return this.queue.remove();
		}
		return null;
	}
	
	protected abstract void filter(I input, InterfacePipe<O> output);

	
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
