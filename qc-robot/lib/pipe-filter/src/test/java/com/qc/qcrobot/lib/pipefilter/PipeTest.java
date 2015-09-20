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
    
    public synchronized void testApp() throws InterruptedException {
    	PipeSinkTest sink = new PipeSinkTest();
    	PipeFilterStringTest filter = new PipeFilterStringTest(sink);
    	PipeSourceTest source = new PipeSourceTest(filter);
    	
    	source.start();
    }
    
//    /**
//     * Tests the pipeline with an Integer.
//     * 
//     * @throws Exception
//     */
//    public void testPipelineInteger() throws Exception {
//    	PipeSourceTest<Integer> source = new PipeSourceTest<Integer>(0);
//    	PipeFilterIntegerTest filter = new PipeFilterIntegerTest();
//    	PipeSinkTest sink = new PipeSinkTest();
//    	
//    	source.connect(filter).connect(sink);
//    	
//    	source.start();
//    	
//    	assertTrue(sink.outputInt == 1);
//    }
//    
//    /**
//     * Tests the pipeline with a String.
//     * 
//     * @throws Exception
//     */
//    public void testPipelineString() throws Exception {
//    	PipeSourceTest<String> source = new PipeSourceTest<String>("ppp");
//    	PipeFilterStringTest filter = new PipeFilterStringTest();
//    	PipeSinkTest sink = new PipeSinkTest();
//    	
//    	source.connect(filter).connect(sink);
//    	
//    	source.start();
//    	
//    	assertTrue(sink.outputString.equals("ccc"));
//    }
//    
//    /**
//     * Tests if PipeInputTypeException is properly thrown.
//     */
//    public void testPipeInputTypeException() {
//    	PipeSourceTest<Integer> source = new PipeSourceTest<Integer>(0);
//    	PipeFilterStringTest filter = new PipeFilterStringTest();
//    	
//    	try {
//    		source.connect(filter);
//    		source.start();
//    	} catch (Exception e) {
//    		if ( !(e instanceof PipeInputTypeException) ) {
//    			fail("Expected Exception: " + new PipeInputTypeException().getMessage());
//    		}
//    	}
//    }
//
//    /**
//     * Tests if PipeMissingSinkException is thrown when the Pipe does not contain a Sink.
//     */
//    public void testPipeMissingSinkException() {
//    	PipeSourceTest<Object> source = new PipeSourceTest<Object>();
//    	
//    	try {
//    		source.start();
//    	} catch (Exception e) {
//    		if ( !(e instanceof PipeMissingSinkException) ) {
//    			fail("Expected Exception: " + new PipeMissingSinkException().getMessage());
//    		}
//    	}
//    }
//    
//    /**
//     * Tests if PipeSinkConnectionException is thrown when a filter is connected as output to a Sink.
//     */
//    public void testPipeSinkConnectionException() {
//    	PipeSinkTest sink = new PipeSinkTest();
//    	
//    	try {
//    		sink.connect(sink);
//    	} catch (Exception e) {
//    		if ( !(e instanceof PipeSinkConnectionException) ) {
//    			fail("Expected Exception: " + new PipeSinkConnectionException().getMessage());
//    		}
//    	}
//    }
    
}
