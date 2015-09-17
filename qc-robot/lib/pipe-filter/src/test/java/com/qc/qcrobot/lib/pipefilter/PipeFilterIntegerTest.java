package com.qc.qcrobot.lib.pipefilter;

/**
 * @author FT_5
 * @company Quality Control
 * @date Sep 17, 2015
 *
 */
public class PipeFilterIntegerTest extends AbstractPipeFilter {

	public <T> void read(T input) throws PipeInputTypeException, PipeMissingSinkException {
		Integer iInput = null;
		
		try {
			iInput = (Integer) input;
		} catch (Exception e) {
			throw new PipeInputTypeException();
		}
		
		this.write(++iInput);
	}
}
