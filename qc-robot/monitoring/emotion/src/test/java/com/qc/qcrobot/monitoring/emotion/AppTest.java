package com.qc.qcrobot.monitoring.emotion;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.Pipe;
import com.qc.qcrobot.monitoring.emotion.*;
import com.qc.qcrobot.monitoring.emotion.filter.AudioFilter;
import com.qc.qcrobot.monitoring.emotion.filter.FreqFilter;
import com.qc.qcrobot.monitoring.emotion.filter.MoodSink;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
     * Run a couple of tests
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void TestAudio() throws InterruptedException {
    	
    	// A couple of test cases
 		ArrayList<Audio> TestCases = new ArrayList<Audio>();
 		TestCases.add(new Audio(15001000L, "mw. Vries, de", new Date()));
	 		TestCases.add(new Audio(25001000L, "mr. Jansen", new Date()));
	 		TestCases.add(new Audio(45001000L, "mw. Boer, de", new Date()));
	 		TestCases.add(new Audio(537455715325L, "mw. Vries, de", new Date()));
	 		TestCases.add(new Audio(637294365821L, "mr. Jansen", new Date()));
	 		TestCases.add(new Audio(924391239584L, "mw. Boer, de", new Date()));
 		
 		//Pipe testing
 		
    	// Create the pipes that transport data between the filters
    	Pipe<Audio> audioInputPipe = new Pipe<>();
    	Pipe<ElderFrequency> freqAnalyzerPipe = new Pipe<>();
        Pipe<ElderMood> moodAnalyzerPipe = new Pipe<>();
        
        // Create the filters
        Filter<Audio, ElderFrequency> audioAnalyzer = new AudioFilter(audioInputPipe, freqAnalyzerPipe);
        Filter<ElderFrequency, ElderMood> moodAnalyzer = new FreqFilter(freqAnalyzerPipe, moodAnalyzerPipe);
        MoodSink moodSink = new MoodSink(moodAnalyzerPipe);
        
        // Start the filters
        audioAnalyzer.start();
        moodAnalyzer.start();
        moodSink.start();
 	
        // Run the test cases
 		for (Audio testCase:TestCases){
 			
 			audioInputPipe.put(testCase);
 			
 			Thread.sleep(100);
 		}
 		// Wait for the threads to finish
 		Thread.sleep(400);
 		
        // Stop the filters
 		audioAnalyzer.stop();
        moodAnalyzer.stop();
        moodSink.stop();
        
        // Output String list
        List<String> output = moodSink.getElderlyMoods().getData();

        
        // Assert it works
        
        ArrayList<String> TestSolutions = new ArrayList<String>();
	        TestSolutions.add(TestCases.get(0).getDate() + " | " + TestCases.get(0).getPerson() + " | " + Mood.Angry);
	        TestSolutions.add(TestCases.get(1).getDate() + " | " + TestCases.get(1).getPerson() + " | " + Mood.Angry);
	        TestSolutions.add(TestCases.get(2).getDate() + " | " + TestCases.get(2).getPerson() + " | " + Mood.Sad);
	        TestSolutions.add(TestCases.get(3).getDate() + " | " + TestCases.get(3).getPerson() + " | " + Mood.Happy);
	        TestSolutions.add(TestCases.get(4).getDate() + " | " + TestCases.get(4).getPerson() + " | " + Mood.Scared);
	        TestSolutions.add(TestCases.get(5).getDate() + " | " + TestCases.get(5).getPerson() + " | " + Mood.Lonely);
	        
        
        for (int i =0; i <output.size(); i++){
        	
        	assertTrue(TestSolutions.get(i).equals(output.get(i)));
        }
        
 		
    	
    }
}
