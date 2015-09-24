package com.qc.qcrobot.monitoring.emotion;

public class HZ {
	
	protected int HZ;

	public HZ ( int HZ) {
		this.HZ = HZ;
	}
	
	public int getHZ (){
		return HZ;
	}

	@Override
	public String toString() {
		return "HZ [HZ=" + HZ + "]";
	}
	
}
