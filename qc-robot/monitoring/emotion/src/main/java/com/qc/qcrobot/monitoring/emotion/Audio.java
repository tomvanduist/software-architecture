package com.qc.qcrobot.monitoring.emotion;

import java.util.Date;

public class Audio {

		protected Long sound;
		protected String person;
		protected Date date;
		
		public Audio (Long sound, String person, Date date ) {
			this.sound = sound;
			this.date = date;
			this.person = person;	
		}
		
		public Long getSound() {
			return sound;
		}
		
		public String getPerson() {
			return person;
		}
		
		public Date getDate() {
			return date;
		}
}
