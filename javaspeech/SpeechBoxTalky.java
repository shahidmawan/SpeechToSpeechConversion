/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspeech;

/**
 *
 * @author Shahid
 */
import java.util.Arrays;

import javaFlacEncoder.FLACFileWriter;

import com.darkprograms.speech.microphone.MicrophoneAnalyzer;

public class SpeechBoxTalky extends Thread {

    private final static MicrophoneAnalyzer microphone = new MicrophoneAnalyzer(FLACFileWriter.FLAC);

    public static void main(String[] args) {
        new SpeechBoxTalky().run();
    }

    public void run() {
        ambientListening();
    }

    public int speakNo = 1;

    public void ambientListening() {
        String filename = "D:\\wav" + speakNo + ".test";
        try {
            microphone.captureAudioToFile(filename);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        final int SILENT = microphone.getAudioVolume();
        boolean hasSpoken = false;
//        boolean[] speaking = new boolean[10];
        boolean[] speaking = new boolean[10];
        Arrays.fill(speaking, false);
        for (int i = 0; i < 100; i++) {
//        for(int i = 0; i<100; i++){
            for (int x = speaking.length - 1; x > 1; x--) {
                speaking[x] = speaking[x - 1];
            }
            int frequency = microphone.getFrequency();
            int volume = microphone.getAudioVolume();
            speaking[0] = frequency < 255 && volume > SILENT && frequency > 85;
            System.out.println(speaking[0]);
            boolean totalValue = false;
            for (boolean bool : speaking) {
                totalValue = totalValue || bool;
            }
            //if(speaking[0] && speaking[2] && speaking[3] && microphone.getAudioVolume()>10){
            if (totalValue && microphone.getAudioVolume() > 20) {
                hasSpoken = true;
            }
            if (hasSpoken && !totalValue) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }

        if (hasSpoken) {
            System.out.println("Has Spoken, now Translating: " + speakNo);
//            Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_US, apiKey);
            try {
                SpeechBoxTalkyThread pThread = new SpeechBoxTalkyThread(filename,speakNo);
                pThread.start();
            } catch (Exception ex) {
            }
        }
        speakNo++;
        if (speakNo < 5) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            ambientListening();
        }
    }

}
