package com.qc.qcrobot.monitoring.emotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElderMood {
	
	protected List<String> elders = new ArrayList<>(); 

	public void addElder(String name, Date date, Mood mood){
		if ( this.elders == null ) {
			this.elders = new ArrayList<>();
		}
		
		// The output format of this filter, could also output this to a file writer
		elders.add(date + " | " + name + " | " + mood);
	
	}
	
	public List<String> getData(){
		return elders;
	}

}
