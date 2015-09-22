package com.qc.qcrobot.lib.pipefilter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for pipe-filter.
 */
public class PipeTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PipeTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( PipeTest.class );
    }
    
    /**
     * Simply test the troughput of the pipe with a string
     * 
     * @throws PipeMissingSinkException
     * @throws InterruptedException 
     */
    public synchronized void testPipeThroughput() throws PipeMissingSinkException, InterruptedException {
    	PipeSinkTest sink = new PipeSinkTest();
    	PipeFilterStringTest filter = new PipeFilterStringTest(sink);
    	PipeSourceTest source = new PipeSourceTest("test", filter);
    	
    	source.startPipe();
    	
    	this.wait(0, 1);
    	source.stopPipe();
		source.joinPipe();
    	
    	assertEquals("test", sink.outputString);
    }

    /**
     * Tests if PipeMissingSinkException is thrown when the Pipe does not contain a Sink.
     */
    public void testPipeMissingSinkException() {
    	PipeSourceTest source = new PipeSourceTest(null, null);
    	
    	try {
    		source.start();
    	} catch (Exception e) {
    		if ( !(e instanceof PipeMissingSinkException) ) {
    			fail("Expected Exception: " + new PipeMissingSinkException().getMessage());
    		}
    	}
    }
}
