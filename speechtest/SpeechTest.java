//package com.wickedcooljava.media;
package speechtest;

import java.util.Locale;
import javax.sound.midi.Synthesizer;

/*import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.JSMLException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
/*
Example code from Wicked Cool Java (No Starch Press)
Copyright (C) 2005 Brian D. Eubanks

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

Note: The LGPL licence can be found online at http://www.gnu.org

*/
/**
 * Example showing simple speech with JSpeech.
 */
public class SpeechTest{/*

	public static void main(String[] args) {
		
		// Create a synthesizer for US English
		try {
			Synthesizer talker = Central.createSynthesizer(
				new SynthesizerModeDesc(null, "general", Locale.US, null, null));
			
			// Get it ready to speak
			talker.allocate();
			talker.resume();

			talker.speak("Java is Wicked Cool, tell all your friends!", null);

			// Wait till speaking is done
			talker.waitEngineState(Synthesizer.QUEUE_EMPTY);

			// Clean up
			talker.deallocate();

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (EngineException e) {
			e.printStackTrace();
		} catch (AudioException e) {
			e.printStackTrace();
		} catch (EngineStateError e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (JSMLException e) {
			e.printStackTrace();
		}


	}
*/}
