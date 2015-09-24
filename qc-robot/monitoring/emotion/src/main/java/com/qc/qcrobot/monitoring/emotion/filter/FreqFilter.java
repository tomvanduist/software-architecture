package com.qc.qcrobot.monitoring.emotion.filter;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.monitoring.emotion.ElderMood;
import com.qc.qcrobot.monitoring.emotion.Frequencies;
import com.qc.qcrobot.monitoring.emotion.ElderFrequency;
import com.qc.qcrobot.monitoring.emotion.Mood;

public class FreqFilter extends Filter<Frequencies, ElderMood>{

	protected ElderMood elder = new ElderMood();
	protected Frequencies freqList = new Frequencies();
	
	public FreqFilter(IPipe<Frequencies> input, IPipe<ElderMood> output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void transformBetween(IPipe<Frequencies> inputPipe, IPipe<ElderMood> outputPipe) {	
		try {
			
			
			while ((freqList = inputPipe.nextOrNullIfEmptied()) != null){
				
				for (ElderFrequency freqElder: freqList.getData()){
					
					elder.addElder(freqElder.getPerson(), freqElder.getDate(), Mood.Angry);		
					
				}
				outputPipe.put(elder);
			}
		} catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
            return;
		}

		outputPipe.put(elder);
	    outputPipe.closeForWriting();
	}

	@Override
	protected ElderMood transformOne(Frequencies in) {
		// TODO Auto-generated method stub
		return null;
	}

}
