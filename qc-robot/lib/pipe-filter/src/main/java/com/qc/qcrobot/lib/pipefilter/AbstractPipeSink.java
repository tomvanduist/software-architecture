package com.qc.qcrobot.lib.pipefilter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Extend this class to implement a PipeSink.
 */
public abstract class AbstractPipeSink<I> extends Thread implements InterfacePipeSink<I> {

	protected Queue<I> queue = new LinkedList<I>();
	
	
	
	protected I read() {
		if ( this.queue != null && !this.queue.isEmpty() )  {
			return this.queue.remove();
		}
		return null;
	}
	
	
	
	@Override
	public void write(I input) {
		if ( this.queue != null ) {
			this.queue.add(input);
		}
	}



	protected abstract void process(I input);

	@Override
	public void run() {
		while ( this.isAlive() ) {
			I input = this.read();
			if ( input != null ) {
				this.process(input);
			}
		}
	}
		
	public synchronized void start() {
		super.start();
	}

	@Override
	public void interrupt() {
		super.interrupt();
	}
}
