package com.qc.qcrobot.monitoring.hearthrate;

import java.util.Date;

public class HearthBeat {

	protected float force;
	protected Date date;
	
	public HearthBeat ( float force, Date date ) {
		this.force = force;
		this.date = date;
	}

	public float getForce() {
		return force;
	}

	public Date getDate() {
		return date;
	}
}
