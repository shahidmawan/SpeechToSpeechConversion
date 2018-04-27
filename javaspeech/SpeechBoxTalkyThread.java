/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspeech;

import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahid
 */
public class SpeechBoxTalkyThread extends Thread {

    String apiKey = "AIzaSyDYTSgBZg9Obx5nwJDNPsk_ldYzct2_tnM";
    String fn;
    int num = 0;

    SpeechBoxTalkyThread(String fName, int no) {
        this.fn = fName;
        this.num = no;
    }

    public void run() {
        displayResponse();
    }

    public void displayResponse() {
        Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_US, apiKey);
        try {
            GoogleResponse gr = rec.getRecognizedDataForFlac(fn);

            if (gr.getResponse() == null) {
                System.out.println((String) null);
                return;
            }
            String res = gr.getResponse();
            System.out.println("Google Response: "+num+" : " + res);
            System.out.println("Google is " + Double.parseDouble(gr.getConfidence()) * 100 + "% confident in"
                    + " the reply");
            /*    System.out.println("Other Possible responses are: ");
    for(String s: gr.getOtherPossibleResponses()){
        System.out.println("\t" + s);
    }*/
//    res= Pick2ndString(res);
            javaspeech.GoogleTranslate translator = new javaspeech.GoogleTranslate("AIzaSyDkETLQ9mpPrQLv6cfX-eWU99przz2nag0");
            String text = translator.translte(res, "en", "ar");
            System.out.println(text);
//                System.out.println("Translated Text: "+text);
//                talk(text);    
        } catch (IOException ex) {
            System.out.println("Exception while recognizing");
            ex.printStackTrace();
            Logger.getLogger(SpeechBoxTalky.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String Pick2ndString(String res) {
        StringTokenizer st = new StringTokenizer(res, "\"},{\"transcript\":\"");
        res = st.nextToken();
//             System.out.println(st.nextToken());  
        return res;

    }
}
