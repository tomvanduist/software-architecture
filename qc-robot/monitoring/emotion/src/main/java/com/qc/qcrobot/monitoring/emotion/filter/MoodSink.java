package com.qc.qcrobot.monitoring.emotion.filter;

import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.lib.pt_1.Sink;
import com.qc.qcrobot.monitoring.emotion.ElderMood;


public class MoodSink extends Sink<ElderMood>{

	protected ElderMood Elderly = null;
	
	public MoodSink(IPipe<ElderMood> input) {
		super(input);
	}

	@Override
	protected void handle(ElderMood in) {
		
		this.Elderly = in;
		
	}
	
	public ElderMood getElderlyMoods(){
		return Elderly;
	}

}
