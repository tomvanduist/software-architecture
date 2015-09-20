package com.qc.qcrobot.lib.pipefilter;

import org.junit.rules.Timeout;

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
     */
    public synchronized void testPipeThroughput() throws PipeMissingSinkException {
    	PipeSinkTest sink = new PipeSinkTest();
    	PipeFilterStringTest filter = new PipeFilterStringTest(sink);
    	PipeSourceTest source = new PipeSourceTest("test", filter);
    	
    	// TODO: Writed threaded tests
    	filter.write(source.read());
    	filter.filter(filter.read(), sink);
    	sink.process(sink.read());
    	
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
