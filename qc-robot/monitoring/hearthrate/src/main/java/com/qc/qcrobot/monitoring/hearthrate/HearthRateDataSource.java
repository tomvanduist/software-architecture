package com.qc.qcrobot.monitoring.hearthrate;

import core.Filter.Filter;
import core.Filter.IPipe;

public class HearthRateDataSource extends Filter<Enum, Boolean> {

	public HearthRateDataSource(IPipe<Enum> input, IPipe<Boolean> output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean transformOne(Enum arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}