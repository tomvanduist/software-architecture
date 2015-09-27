package com.qc.qcrobot.monitoring.logging;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;
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
     * Test using two keywords. TestFile can be found in logging module root folder.
     * @throws InterruptedException 
     */
    public void testTwoKeywords() throws InterruptedException
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
    		br.close();
    	} catch (IOException x) {
    	    System.err.format("IOException: %s%n", x);
    	}
        
        //Create keyword filters, couple to sink.
    	Filter<String, String> keywordFilter = new KeywordFilter(input, out1, "medical");
    	Filter<String, String> keywordFilter2 = new KeywordFilter(out1, out2, "Janssen");
    	StringSink sink = new StringSink(out2);
        
    	keywordFilter.start();
    	keywordFilter2.start();
        sink.start();

        keywordFilter.stop();
    	keywordFilter2.stop();
        sink.stop();
        
        Thread.sleep(300);
        
        List<String> result = sink.getOutput();
        String filtered = "2015.09.27 at 22:08:52: medical staff alerted, mrs Janssen in trouble";
        System.out.println("test finished");
        assertTrue( filtered.equals(result.get(0)));
    }
}
