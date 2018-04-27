/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspeech;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.synthesiser.Synthesiser;
import com.darkprograms.speech.translator.GoogleTranslate;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaFlacEncoder.FLACFileWriter;

/**
 *
 * @author Shahid
 */
public class GDuplexSpeech {
    String GoogleKey = "AIzaSyDYTSgBZg9Obx5nwJDNPsk_ldYzct2_tnM";
    public static void main(String[] args){
        GDuplexSpeech gds = new GDuplexSpeech();
        
    GSpeechDuplex dup = new GSpeechDuplex(gds.GoogleKey);//Instantiate the API
    dup.addResponseListener(new GSpeechResponseListener(){// Adds the listener
        public void onResponse(GoogleResponse gr){
            String res = gr.getResponse();
            System.out.println("Google thinks you said: " + res);
            System.out.println("with " + 
            ((gr.getConfidence()!=null)?(Double.parseDouble(gr.getConfidence())*100):null) 
                + "% confidence.");
            System.out.println("Google also thinks that you might have said:" 
                    + gr.getOtherPossibleResponses());
            try {
                System.out.println(GoogleTranslate.translate("en-US", "ar-ae", res));
            } catch (IOException ex) {
                System.out.println("Problem while translating");
                Logger.getLogger(GDuplexSpeech.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    Microphone mic = new Microphone(FLACFileWriter.FLAC);//Instantiate microphone and have 
    // it record FLAC file.
    File file = new File("CRAudioTest.flac");//The File to record the buffer to. 
    //You can also create your own buffer using the getTargetDataLine() method.
    while(true){
        try{
            mic.captureAudioToFile(file);//Begins recording
            Thread.sleep(10000);//Records for 10 seconds
            mic.close();//Stops recording
            //Sends 10 second voice recording to Google
            byte[] data = Files.readAllBytes(mic.getAudioFile().toPath());//Saves data into memory.
                    dup.recognize(data, (int)mic.getAudioFormat().getSampleRate());
            mic.getAudioFile().delete();//Deletes Buffer file
            //REPEAT
        }
        catch(Exception ex){
            ex.printStackTrace();//Prints an error if something goes wrong.
        }
    }
}
public static void talk(String text){
    //String language = "auto";//Uses language autodetection
            //** While the API can detect language by itself, this is reliant on the Google Translate API which is prone to breaking. For maximum stability, please specify the language.**//
        String language = "ar-ae";//English (US) language code   //If you want to specify a language use the ISO code for your country. Ex: en-us
    /*If you are unsure of this code, use the Translator class to automatically detect based off of
    * Either text from your language or your system settings.
    */
    Synthesiser synth = new Synthesiser(language);
    try {
        InputStream is = synth.getMP3Data(text);
        //TODO Use any Java MP3 Implementation to play back the AudioFile from the InputStream.
    } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println("Error");
        e.printStackTrace();
        return;
    }
   }
}
