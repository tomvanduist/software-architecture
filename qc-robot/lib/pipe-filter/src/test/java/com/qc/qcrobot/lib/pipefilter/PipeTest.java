package com.qc.qcrobot.lib.pipefilter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PipeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PipeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PipeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Pipe pipe = new Pipe();
        Filter filter = new FilterTest("a");
        pipe.registerFilter(filter).registerFilter(filter);
        
        pipe.run();
        
        assertTrue(filter.getOutput().length() == 4);
    }
}
