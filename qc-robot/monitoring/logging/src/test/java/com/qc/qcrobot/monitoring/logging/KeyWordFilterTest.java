package com.qc.qcrobot.monitoring.logging;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.util.Date;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.Pipe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
*
* @author Kevin
*/

/**
 * Unit test for simple App.
 */

public class KeyWordFilterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KeyWordFilterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KeyWordFilterTest.class );
    }
     
    /**
     * Rigourous Test :-)
     * @throws InterruptedException 
     */
    public void testApp() throws InterruptedException
    {	
    	// Create input and output pipes.
    	Pipe<String> input = new Pipe<>();
        Pipe<String> out1 = new Pipe<>();
        Pipe<String> out2 = new Pipe<>();
        
        // Fill the pipe
        try {
        	String s;
    		FileReader fr = new FileReader("loggingExample");
    		BufferedReader br = new BufferedReader(fr);
    		while((s = br.readLine())!= null) {
    			input.put(s);
    		}
    	} catch (IOException x) {
    	    System.err.format("IOException: %s%n", x);
    	}
        
        Date din, dout;
        din = new Date();
        dout = new Date();

        //Create keyword filter, coupled to sink.
    	Filter<String, String> keywordFilter = new KeywordFilter(input, out1, "medical");
    	Filter<String, String> dateFilter = new DateFilter(out1, out2, din, dout);
    	StringSink sink = new StringSink(out2);
        
    	keywordFilter.start();
    	dateFilter.start();
        sink.start();

        keywordFilter.stop();
    	dateFilter.stop();
        sink.stop();
        
        Thread.sleep(300);
            
        System.out.println("test finished");
        assertTrue( true );
    }
}
