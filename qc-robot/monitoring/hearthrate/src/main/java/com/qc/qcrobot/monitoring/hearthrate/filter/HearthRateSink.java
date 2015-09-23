package com.qc.qcrobot.monitoring.hearthrate.filter;

import com.qc.qcrobot.monitoring.hearthrate.HearthRate;

import core.Filter.IPipe;
import core.Filter.Sink;

public class HearthRateSink extends Sink<HearthRate> {
	
	protected HearthRate hearthRate = null;

	public HearthRateSink(IPipe<HearthRate> input) {
		super(input);
	}

	@Override
	protected void handle(HearthRate hearthRate) {
		this.hearthRate = hearthRate;
	}

	public HearthRate getHearthRate() {
		return hearthRate;
	}
}
