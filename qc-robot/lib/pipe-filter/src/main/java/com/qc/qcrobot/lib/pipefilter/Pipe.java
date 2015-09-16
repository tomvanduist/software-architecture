package com.qc.qcrobot.lib.pipefilter;

//import Filter;

import java.util.ArrayList;
import java.util.List;

public class Pipe {
	
	private final List<Filter> filterList = new ArrayList<Filter>();
	
	public Pipe registerFilter(Filter filter) {
		this.filterList.add(filter);
		System.err.println(this.filterList.get(this.filterList.indexOf(filter)));
		return this;
	}
	
	public void run() {
		for (Filter f : this.filterList) {
			System.err.println(f);
		}
	}
}
