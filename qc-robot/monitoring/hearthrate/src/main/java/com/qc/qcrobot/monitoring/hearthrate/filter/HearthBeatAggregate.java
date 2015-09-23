package com.qc.qcrobot.monitoring.hearthrate.filter;

import java.util.Date;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.monitoring.hearthrate.HearthBeat;


public class HearthBeatAggregate extends Filter<Integer, HearthBeat> {
	
	protected Integer threshold;

	public HearthBeatAggregate(IPipe<Integer> input, IPipe<HearthBeat> output, Integer threshold) {
		super(input, output);
		
		this.threshold = threshold;
	}

	@Override
	protected void transformBetween(IPipe<Integer> inputPipe, IPipe<HearthBeat> outputPipe) {
	    try {
            Integer in;
            while ((in = inputPipe.nextOrNullIfEmptied()) != null) {
            	HearthBeat out;
                
                if ( (out = transformOne(in)) != null ) {
                	outputPipe.put(out);                	
                }
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
            return;
        }
	    outputPipe.closeForWriting();
	}



	@Override
	protected HearthBeat transformOne(Integer input) {
		if ( input > threshold ) {
			return new HearthBeat(input, new Date());
		} else {
			return null;
		}
	}

}