package com.qc.qcrobot.monitoring.logging;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.io.IOException;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;

/**
*
* @author Kevin
*/

/* Filters all lines from a file that contain a given keyword */

public class LoggingKeywordFilter extends Filter <BufferedReader, StringWriter> {
	
	// Filter lines having this keyword.
	private String keyword = null;
	
	public LoggingKeywordFilter(IPipe<BufferedReader> input, IPipe<StringWriter> output, String keyword) {
		super(input, output);
		this.keyword = keyword;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see core.Filter.Filter#transformOne(java.lang.Object)
	 * Filter out 
	 */
	@Override
	protected StringWriter transformOne(BufferedReader in) {
		//get input:
		String s;
		StringWriter out = new StringWriter();
		try {
			while((s = in.readLine())!= null) {
				if (s.toLowerCase().contains(keyword.toLowerCase())) {
					out.write(s);
					System.out.println(s);
					//write to StringWriter
				};
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
	
}
