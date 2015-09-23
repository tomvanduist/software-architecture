package com.qc.qcrobot.monitoring.hearthrate.filter;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.monitoring.hearthrate.HearthBeat;
import com.qc.qcrobot.monitoring.hearthrate.HearthRate;


public class HearthRateAggragate extends Filter<HearthBeat, HearthRate> {
	
	protected HearthRate currentHearthRate = new HearthRate();

	public HearthRateAggragate(IPipe<HearthBeat> input, IPipe<HearthRate> output) {
		super(input, output);
	}
	
	@Override
	protected void transformBetween(IPipe<HearthBeat> inputPipe, IPipe<HearthRate> outputPipe) {
	    try {
	    	HearthBeat hearthBeat;
            while ((hearthBeat = inputPipe.nextOrNullIfEmptied()) != null) {
//            	System.out.println(hearthBeat);
            	currentHearthRate.addHearthBeat(hearthBeat);
            	outputPipe.put(currentHearthRate);
            }
        } catch (InterruptedException e) {
    	    System.out.println(currentHearthRate);
            System.err.println("InterruptedException occurred");
            return;
        }
	    outputPipe.put(currentHearthRate);
	    outputPipe.closeForWriting();
	}

	@Override
	protected HearthRate transformOne(HearthBeat hearthBeat) {
		if ( currentHearthRate == null ) {
			currentHearthRate = new HearthRate();
		}
		
		currentHearthRate.addHearthBeat(hearthBeat);
		
		return null;
	}

}
