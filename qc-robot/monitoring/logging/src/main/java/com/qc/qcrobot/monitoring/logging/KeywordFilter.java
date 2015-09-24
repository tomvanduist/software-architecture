package com.qc.qcrobot.monitoring.logging;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.io.IOException;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;

/**
*
* @author Kevin van den Bekerom
*/

/* Filters all lines from a file that contain a given keyword */

public class KeywordFilter extends Filter <String, String> {
	
	// Filter lines having this keyword.
	private String keyword = null;
	
	public KeywordFilter(IPipe<String> input, IPipe<String> output, String keyword) {
		super(input, output);
		this.keyword = keyword;
	}
	
	protected void transformBetween(IPipe<String> input, IPipe<String> output) {
        try {
            String in;
            while ((in = input.nextOrNullIfEmptied()) != null) {
                String out = transformOne(in);
                if (out != null) {
                	output.put(out);
                }
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
            return;
        }
        output.closeForWriting();
    }
	/* 
	 * (non-Javadoc)
	 * @see core.Filter.Filter#transformOne(java.lang.Object)
	 * Filter out 
	 */
	@Override
	protected String transformOne(String in) {
		//get input:
		if (in.toLowerCase().contains(keyword.toLowerCase())) {
			return in;
		}
		else return null;
	}
	
}
