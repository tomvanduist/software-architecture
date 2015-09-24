package com.qc.qcrobot.monitoring.emotion.filter;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;
import com.qc.qcrobot.monitoring.emotion.Audio;
import com.qc.qcrobot.monitoring.emotion.ElderFrequency;
import com.qc.qcrobot.monitoring.emotion.HZ;

public class AudioFilter extends Filter<Audio, ElderFrequency> {

	
	
	public AudioFilter(IPipe<Audio> input, IPipe<ElderFrequency> output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void transformBetween(IPipe<Audio> inputPipe, IPipe<ElderFrequency> outputPipe) {
		
		try {
			
			// Create an audio instance;
			Audio sound;
			
			// Loop over the input into the audio instance
			while ((sound = inputPipe.nextOrNullIfEmptied()) != null){
				
				// Create a new Frequency object to store frequencies
				ElderFrequency elderFreq = new ElderFrequency();
				
				// Set date and person.
				elderFreq.setDate(sound.getDate());
				elderFreq.setPerson(sound.getPerson());
				
				// Convert the integer from sound to a string
				String analyzeAudio = sound.getSound() + "";
				
				// Loop over the string, microphone range is between 0 and 9999 so pick the first four digits
				while (analyzeAudio.length() >= 2){
					
					// Super complicated algorithm that analyzes frequencies.
					elderFreq.addFrequencies(new HZ(Integer.parseInt(analyzeAudio.substring(0, 4))));
					
					// Drop the processed audio from the string
					analyzeAudio = analyzeAudio.substring(4);	
				}
				// Send the created frequency object to the next pipe.
				outputPipe.put(elderFreq);
			}
		} catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
            return;
		}
			
	    
	    outputPipe.closeForWriting();
	}
	
	@Override
	protected ElderFrequency transformOne(Audio in) {
		// TODO Auto-generated method stub
		return null;
	}

}
