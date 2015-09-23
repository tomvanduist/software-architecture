package com.qc.qcrobot.lib.pt_1.Doorbell;

/**
 *
 * @author sander
 */
 
    public enum DoorbellEnum {
	Closed("C"), Pending("P"), Opened("O");

	private String doorbellCode;

	private DoorbellEnum(String d) {
		doorbellCode = d;
	}

	public String getStatusCode() {
		return doorbellCode;
	}

}