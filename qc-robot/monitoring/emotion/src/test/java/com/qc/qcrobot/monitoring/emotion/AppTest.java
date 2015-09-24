package com.qc.qcrobot.monitoring.emotion;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.qc.qcrobot.monitoring.emotion.*;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void TestAudio() {
    	Audio mp3 = new Audio(120, 150000, "mw. Vries, de", new Date());
    	
    	// Frequency freq = new Frequency ();
    	
    	// freq.addFrequencies(new HZ (25));
    	
    	// freq.addFrequencies(new HZ (75));
    	
    	// System.out.println(freq.getFrequencies() + " " + freq.avgHZ);
    	
    	System.out.println(mp3.getLength() +"<- Length " + mp3.getPerson() +"<- Person " +mp3.getSound() +"<- Sound " + mp3.getDate() + "<- Date ");
    }
}
