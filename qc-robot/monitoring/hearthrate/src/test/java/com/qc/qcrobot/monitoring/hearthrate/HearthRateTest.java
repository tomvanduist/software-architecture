package com.qc.qcrobot.monitoring.hearthrate;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.qc.qcrobot.monitoring.hearthrate.filter.HearthBeatAggregate;
import com.qc.qcrobot.monitoring.hearthrate.filter.HearthRateAggragate;
import com.qc.qcrobot.monitoring.hearthrate.filter.HearthRateSink;

import core.Filter.Filter;
import core.Filter.Pipe;
import core.Filter.Sink;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HearthRateTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HearthRateTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( HearthRateTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }
    
    public void testHearthMonitor() throws InterruptedException {
    	
    	Integer threshold = 50;
    	
    	System.out.println("Starting hearth rate measurement..");
    	System.out.println("Will filter noice below threshold: " + threshold);
    	
    	// Create the pipes that transport data between the filters
    	Pipe<Integer> rawInputPipe = new Pipe<>();
        Pipe<HearthBeat> hearthBeatPipe = new Pipe<>();
        Pipe<HearthRate> hearthRatePipe = new Pipe<>();
        
        // Create the filters
        //
        // 1. The beatAggregator aggregates raw integers integers into hearthbeats, noise below a certain threshold is filtered
        // 2. The rateAggragator aggregates these hearthbeats into a HearthRate object
        // 3. The rateSink is where the final HearthBeat object ends up
        Filter<Integer, HearthBeat> beatAggragate = new HearthBeatAggregate(rawInputPipe, hearthBeatPipe, threshold);
        Filter<HearthBeat, HearthRate> rateAggragate = new HearthRateAggragate(hearthBeatPipe, hearthRatePipe);
        HearthRateSink rateSink = new HearthRateSink(hearthRatePipe);
        
        // Start the filters
        beatAggragate.start();
        rateAggragate.start();
        rateSink.start();
        
        // Input some random integers as random hearth beat data
        ArrayList<Integer> rawData = new ArrayList<>();
        for ( int i = 0; i < 50; i++ ) {
        	Integer input = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        	rawInputPipe.put(input);
        	rawData.add(input);
        	
        	Thread.sleep(ThreadLocalRandom.current().nextInt(0, 20 + 1));
        }
        
        System.out.println("Raw data: " + rawData);
        
        // Give the filters some time to finish
        Thread.sleep(300);
        
        // Stop the filters 
        beatAggragate.stop();
        rateAggragate.stop();
        rateSink.stop();
        
        System.out.println("Measured hearthrate: " + rateSink.getHearthRate().getBeatsPerMinute());
        
        assertTrue(rateSink.getHearthRate().getBeatsPerMinute() > 0);
    }
}
