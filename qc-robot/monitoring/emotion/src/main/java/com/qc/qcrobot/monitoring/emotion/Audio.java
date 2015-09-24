package com.qc.qcrobot.monitoring.emotion;

import java.util.Date;

public class Audio {

		protected int length;
		protected int sound;
		protected String person;
		protected Date date;
		
		public Audio ( int length, int sound, String person, Date date ) {
			this.length = length;
			this.sound = sound;
			this.date = date;
			this.person = person;	
		}

		public int getLength() {
			return length;
		}
		
		public int getSound() {
			return sound;
		}
		
		public String getPerson() {
			return person;
		}
		
		public Date getDate() {
			return date;
		}
}
