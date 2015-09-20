package com.qc.qcrobot.lib.pipefilter;

public interface InterfacePipe<I> extends Runnable {
	
	public void write(I input);
	
	public void start();
	public void interrupt();
}
