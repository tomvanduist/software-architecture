package com.qc.qcrobot.monitoring.logging;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;


/* Filters all lines from a file that contain a given keyword */

public class LoggingKeywordFilter extends Filter <BufferedReader, BufferedWriter> {
	
	// Filter lines having this keyword.
	private String keyword = null;
	
	public LoggingKeywordFilter(IPipe<BufferedReader> input, IPipe<BufferedWriter> output, String keyword) {
		super(input, output);
		this.keyword = keyword;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see core.Filter.Filter#transformOne(java.lang.Object)
	 * Filter out 
	 */
	@Override
	protected BufferedWriter transformOne(BufferedReader in) {
		//get input:
		String s;
		BufferedWriter out = new BufferedWriter(null);
		try {
			while((s = in.readLine())!= null) {
				if (s.toLowerCase().contains(keyword.toLowerCase())) {
					out.write(s);
					System.out.println(s);
					out.newLine();
					//write to bufferedwriter
				};
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
	
}
