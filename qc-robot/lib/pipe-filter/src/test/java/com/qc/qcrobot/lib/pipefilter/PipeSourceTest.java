package com.qc.qcrobot.lib.pipefilter;

public class PipeSourceTest extends AbstractPipeSource {

	@Override
	public void start() {
		this.write("test");
	}
}
