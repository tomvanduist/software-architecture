package com.qc.qcrobot.lib.pipefilter;

public class PipeFilterTest extends AbstractPipeFilter {

	public void read(String input) {
		
		this.write(input.replace('p', 'c'));
	}
}
