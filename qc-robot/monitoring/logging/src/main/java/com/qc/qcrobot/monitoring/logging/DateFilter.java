package com.qc.qcrobot.monitoring.logging;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;

/**
*
* @author Kevin van den Bekerom
*/

/* Filters all lines from a file that contain a given keyword */

public class DateFilter extends Filter <String, String> {
	
	// Filter lines having this keyword.
	private Date min = null;
	private Date max = null;
	
	public DateFilter(IPipe<String> input, IPipe<String> output, Date min, Date max) {
		super(input, output);
		this.min = min;
		this.max = max;
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
		try {
            DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss zzz yyyy");
            Date result =  df.parse(in);
            System.out.println(result); 
            if (result.after(min) && result.before(max)) {
            	return in;
            } else {
            	return null;
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
            return null;
        }
	}
	
}
