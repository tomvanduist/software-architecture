package com.qc.qcrobot.lib.pipefilter;

//import Filter;

import java.util.ArrayList;
import java.util.List;

public class Pipe {
	
	private final List<Filter> filterList = new ArrayList<Filter>();
	
	public Pipe registerFilter(Filter filter) {
		this.filterList.add(filter);
		return this;
	}
	
	public void run() {
		String current = null;
		for (Filter f : this.filterList) {
			current = f.perform(current);
		}
	}
}
