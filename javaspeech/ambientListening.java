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
import java.io.*;
import com.darkprograms.speech.microphone.MicrophoneAnalyzer;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import java.io.File;
import javaFlacEncoder.FLACFileWriter;

public class ambientListening {

    public static void main(String[] args) {
        ambientListeningLoop(args);
    }

    public static void ambientListeningLoop(String[] args) {
        String langFrom = "en";
        String langTo = "ar";
        String apiKey = "AIzaSyDYTSgBZg9Obx5nwJDNPsk_ldYzct2_tnM";
        MicrophoneAnalyzer mic = new MicrophoneAnalyzer(FLACFileWriter.FLAC);
        mic.setAudioFile(new File("D:\\AudioTestNow.flac"));
        int loop = 0;
        while (loop <= 2) {
            loop++;
            mic.open();
            final int THRESHOLD = 8;
            int volume = mic.getAudioVolume();
            boolean isSpeaking = (volume > THRESHOLD);
            if (isSpeaking) {
                try {
                    System.out.println("RECORDING...");
                    mic.captureAudioToFile(mic.getAudioFile());//Saves audio to file.
                    int i = 0;
                    do {
                        Thread.sleep(1000);//Updates every second
                        i++;  if (i >= 3) {   break;   }
//                        if(mic.getAudioVolume() < THRESHOLD){System.out.println("Exiting");break;}
                        
                    } while (mic.getAudioVolume() > THRESHOLD);

                    System.out.println("Recording Complete!");
                    System.out.println("Recognizing...");
//                Recognizer rec = new Recognizer(Recognizer.Languages.AUTO_DETECT,apiKey);
                    Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_UK, apiKey);
                    GoogleResponse gr = rec.getRecognizedDataForFlac(mic.getAudioFile(), 3);
                    String res = gr.getResponse();
                    displayResponse(gr);//Displays output in Console

                    javaspeech.GoogleTranslate translator = new javaspeech.GoogleTranslate(apiKey);
                    try {
                        String text = translator.translte(res, langFrom, langTo);
                        System.out.println("Translated Text: " + text);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Looping back");//Restarts loops

                } catch (Exception e) {

                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("Error Occured");
                } finally {
                    mic.close();//Makes sure microphone closes on exit.
                }
            }
        }
    }

    private static void displayResponse(GoogleResponse gr) {
        if (gr.getResponse() == null) {
            System.out.println((String) null);
            return;
        }
        System.out.println("Google Response: " + gr.getResponse());
        System.out.println("Google is " + Double.parseDouble(gr.getConfidence()) * 100 + "% confident in"
                + " the reply");
        System.out.println("Other Possible responses are: ");
        for (String s : gr.getOtherPossibleResponses()) {
            System.out.println("\t" + s);
        }
    }

}
