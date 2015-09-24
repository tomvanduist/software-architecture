package com.qc.qcrobot.monitoring.logging;

import java.util.ArrayList;
import java.util.List;

import com.qc.qcrobot.lib.pt_1.*;

/**
 *
 * @author Kevin van den Bekerom
 */
public class StringSink extends Sink<String> {

    public StringSink(IPipe<String> input) {
		super(input);
	}

	private List<String> Output = new ArrayList<String>();

  
    public List<String> getOutput() {
        return Output;
    }

    @Override
    public void takeFrom(IPipe<String> pipe) {
        try {
        	String in;
            while ((in = pipe.nextOrNullIfEmptied()) != null) {
            	System.out.println(in);
                Output.add(in);
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred: " + e.getStackTrace());
        } finally {
            System.out.close();
        }
    }

    @Override
    protected void handle(String in) {

    }
}