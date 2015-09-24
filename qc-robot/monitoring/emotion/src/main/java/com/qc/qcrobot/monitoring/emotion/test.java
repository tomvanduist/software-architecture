package com.qc.qcrobot.monitoring.emotion;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.Pipe;
import com.qc.qcrobot.monitoring.emotion.filter.AudioFilter;
import com.qc.qcrobot.monitoring.emotion.filter.FreqFilter;
import com.qc.qcrobot.monitoring.emotion.filter.MoodSink;

public class test {

 	public static void main(String[] args) throws InterruptedException {
 		Audio mp3_1 = new Audio(120, 150000, "mw. Vries, de", new Date());
 		Audio mp3_2 = new Audio(120, 150000, "mr. Jansen", new Date());
 		Audio mp3_3 = new Audio(120, 150000, "mw. Boer, de", new Date());
 		
 		//Pipe testing
 		
    	// Create the pipes that transport data between the filters
    	Pipe<Audio> audioInputPipe = new Pipe<>();
    	Pipe<Frequencies> freqAnalyzerPipe = new Pipe<>();
        Pipe<ElderMood> moodAnalyzerPipe = new Pipe<>();
        
        // Create the filters
        //
        // 1. The beatAggregator aggregates raw integers integers into hearthbeats, noise below a certain threshold is filtered
        // 2. The rateAggragator aggregates these hearthbeats into a HearthRate object
        // 3. The rateSink is where the final HearthBeat object ends up
        Filter<Audio, Frequencies> audioAnalyzer = new AudioFilter(audioInputPipe, freqAnalyzerPipe);
        Filter<Frequencies, ElderMood> moodAnalyzer = new FreqFilter(freqAnalyzerPipe, moodAnalyzerPipe);
        MoodSink moodSink = new MoodSink(moodAnalyzerPipe);
        
        // Start the filters
        audioAnalyzer.start();
        moodAnalyzer.start();
        moodSink.start();
        
    	
        
        // Feed the mp3
        audioInputPipe.put(mp3_1);
        
        Thread.sleep(10);
        
        audioInputPipe.put(mp3_2);
        
        Thread.sleep(10);
        
        audioInputPipe.put(mp3_3);
        
        // Give the filters some time to finish
        Thread.sleep(300);
        
        audioAnalyzer.stop();
        moodAnalyzer.stop();
        moodSink.stop();
        
        for (String elder:moodSink.getElderlyMoods().getData()){
        	System.out.println(elder);
        }
	}
}
