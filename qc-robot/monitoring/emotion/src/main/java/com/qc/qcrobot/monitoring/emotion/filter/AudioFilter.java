package com.qc.qcrobot.monitoring.emotion.filter;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.monitoring.emotion.Audio;
import com.qc.qcrobot.monitoring.emotion.ElderFrequency;
import com.qc.qcrobot.monitoring.emotion.Frequencies;

public class AudioFilter extends Filter<Audio, Frequencies> {

	protected Frequencies freqList = new Frequencies();
	
	public AudioFilter(IPipe<Audio> input, IPipe<Frequencies> output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void transformBetween(IPipe<Audio> inputPipe, IPipe<Frequencies> outputPipe) {
		
		try {
			Audio sound;
			
			ElderFrequency elderFreq = new ElderFrequency();
			
			while ((sound = inputPipe.nextOrNullIfEmptied()) != null){
				
				elderFreq.setDate(sound.getDate());
				elderFreq.setPerson(sound.getPerson());
				
				freqList.addElderFrequency(elderFreq);
				
				outputPipe.put(freqList);
			}
		} catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
            return;
		}
			
	    
	    outputPipe.closeForWriting();
	}
	
	@Override
	protected Frequencies transformOne(Audio in) {
		// TODO Auto-generated method stub
		return null;
	}

}
