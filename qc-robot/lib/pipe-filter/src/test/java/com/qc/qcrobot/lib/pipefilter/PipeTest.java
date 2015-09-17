package com.qc.qcrobot.lib.pipefilter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
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
     * 
     * @throws Exception
     */
    public void testPipelineInteger() throws Exception {
    	PipeSourceTest<Integer> source = new PipeSourceTest<Integer>(0);
    	PipeFilterIntegerTest filter = new PipeFilterIntegerTest();
    	PipeSinkTest sink = new PipeSinkTest();
    	
    	source.connect(filter).connect(sink);
    	
    	source.start();
    	
    	assertTrue(sink.outputInt == 1);
    }
    
    /**
     * 
     * @throws Exception
     */
    public void testPipelineString() throws Exception {
    	PipeSourceTest<String> source = new PipeSourceTest<String>("ppp");
    	PipeFilterStringTest filter = new PipeFilterStringTest();
    	PipeSinkTest sink = new PipeSinkTest();
    	
    	source.connect(filter).connect(sink);
    	
    	source.start();
    	
    	assertTrue(sink.outputString.equals("ccc"));
    }
    
    /**
     * 
     */
    public void testPipeInputTypeException() {
    	PipeSourceTest<Integer> source = new PipeSourceTest<Integer>(0);
    	PipeFilterStringTest filter = new PipeFilterStringTest();
    	
    	try {
    		source.connect(filter);
    		source.start();
    	} catch (Exception e) {
    		if ( !(e instanceof PipeInputTypeException) ) {
    			fail("Expected Exception: " + new PipeInputTypeException().getMessage());
    		}
    	}
    }

    /**
     * 
     */
    public void testPipeMissingSinkException() {
    	PipeSourceTest<Object> source = new PipeSourceTest<Object>();
    	
    	try {
    		source.start();
    	} catch (Exception e) {
    		if ( !(e instanceof PipeMissingSinkException) ) {
    			fail("Expected Exception: " + new PipeMissingSinkException().getMessage());
    		}
    	}
    }
    
    /**
     * 
     */
    public void testPipeSinkConnectionException() {
    	PipeSinkTest sink = new PipeSinkTest();
    	
    	try {
    		sink.connect(sink);
    	} catch (Exception e) {
    		if ( !(e instanceof PipeSinkConnectionException) ) {
    			fail("Expected Exception: " + new PipeSinkConnectionException().getMessage());
    		}
    	}
    }
    
}
