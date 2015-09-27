package com.qc.qcrobot.monitoring.emotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElderFrequency {
	
	protected List<HZ> Frequencies = new ArrayList<>();
	protected HZ avgHZ;
	protected String person;
	protected Date date;
	
	public List<HZ> getFrequencies() {
		return Frequencies;
	}
	
	public void addFrequencies(HZ hz){
		if ( this.Frequencies == null ) {
			this.Frequencies = new ArrayList<>();
		}
		
		this.Frequencies.add(hz);		
	}
	
	
	public HZ getAvarageFrequency(){
		
		Long Freq = 0L;
		if (Frequencies != null){
	
			for (HZ hz: Frequencies){
				Freq += hz.getHZ();
			}
			
			Integer avarage = (int) (Freq / (long) Frequencies.size());
			
			avgHZ = new HZ(avarage);
			
		}else{ 
			
			avgHZ = new HZ(0);
		}
		
		return avgHZ;
	}
	
	public void setPerson(String person) {
		this.person = person;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getPerson() {
		return person;
	}
	
	public Date getDate() {
		return date;
	}
}
