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
		
		elders.add(date + " | " + name + " | " + mood);
	
	}
	
	public List<String> getData(){
		return elders;
	}

}
