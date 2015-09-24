package com.qc.qcrobot.monitoring.hearthrate;

import java.util.ArrayList;
import java.util.List;

public class HearthRate {
	
	protected List<HearthBeat> hearthBeats = new ArrayList<>();

	public List<HearthBeat> getHearthBeats() {
		return hearthBeats;
	}

	public void setHearthBeats(List<HearthBeat> hearthBeats) {
		this.hearthBeats = hearthBeats;
	}
	
	public void addHearthBeat( HearthBeat hearthBeat ) {
		if ( this.hearthBeats == null ) {
			this.hearthBeats = new ArrayList<>();
		}
		
		this.hearthBeats.add(hearthBeat);
	}
	
	public float getBeatsPerMinute() {
		if ( this.hearthBeats != null && this.hearthBeats.size() > 0 ) {
			long prevBeat = 0;
			float millis = 0;
			
			for ( HearthBeat hearthBeat : this.hearthBeats ) {
				long curBeat = (int) hearthBeat.getDate().getTime();
				
				if ( prevBeat != 0 ) {
					millis += (curBeat - prevBeat);
				}
				
				prevBeat = curBeat;
			}
			
			return this.hearthBeats.size() / (millis / 1000 / 60);
		}
		
		return (float) 0.0;
	}
}
