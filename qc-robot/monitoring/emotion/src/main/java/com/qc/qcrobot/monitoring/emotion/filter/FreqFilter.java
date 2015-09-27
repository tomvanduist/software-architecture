package com.qc.qcrobot.monitoring.emotion.filter;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.monitoring.emotion.ElderMood;
import com.qc.qcrobot.monitoring.emotion.HZ;
import com.qc.qcrobot.monitoring.emotion.ElderFrequency;
import com.qc.qcrobot.monitoring.emotion.Mood;

public class FreqFilter extends Filter<ElderFrequency, ElderMood>{

	protected ElderMood elder = new ElderMood();
	protected ElderFrequency freq = new ElderFrequency();
	
	public FreqFilter(IPipe<ElderFrequency> input, IPipe<ElderMood> output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void transformBetween(IPipe<ElderFrequency> inputPipe, IPipe<ElderMood> outputPipe) {	
		try {
			
			
			while ((freq = inputPipe.nextOrNullIfEmptied()) != null){
		
				Integer avgFreq = freq.getAvarageFrequency().getHZ(); 
				
				Mood mood = Mood.Lonely;
				
				if (avgFreq <= 2000){
					mood = Mood.Angry;
				}else if (avgFreq<=4000){
					mood = Mood.Sad;
				}else if (avgFreq<=6000){
					mood = Mood.Happy;
				}else if (avgFreq <=8000){
					mood = Mood.Scared;
				}
				
				elder.addElder(freq.getPerson(), freq.getDate(), mood);
				
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
	protected ElderMood transformOne(ElderFrequency in) {
		// TODO Auto-generated method stub
		return null;
	}

}
