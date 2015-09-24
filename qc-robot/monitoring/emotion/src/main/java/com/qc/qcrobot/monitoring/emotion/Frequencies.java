package com.qc.qcrobot.monitoring.emotion;

import java.util.ArrayList;
import java.util.List;

public class Frequencies {
	
	protected List<ElderFrequency> frequenties = new ArrayList<>(); 

	public void addElderFrequency(ElderFrequency freq){
		if ( this.frequenties == null ) {
			this.frequenties = new ArrayList<>();
		}
		frequenties.add(freq);
	
	}
	
	public List<ElderFrequency> getData(){
		return frequenties;
	}
}
