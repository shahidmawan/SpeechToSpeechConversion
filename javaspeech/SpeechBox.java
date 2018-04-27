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
import com.google.api.translate.Language;
import com.gtranslate.Audio;
//import com.gtranslate.Translator;
import com.google.api.translate.TextTranslator;

import com.gtranslate.context.TranslateEnvironment;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaFlacEncoder.FLACFileWriter;
import main.java.MSpeechBox;

@SuppressWarnings("restriction")
/**
 *
 * @author Shahid
 */
public class SpeechBox extends Thread {
// pa=punjabi, ms=malay, ar=arabic, en=english, hi=hindi, ur=urdu

    String SpeechKey = "df";
//    static String SpeechKey = "fd-RxpEpC8aKrRnmc";
    String langFrom = "en";
    String langTo = "ar";
//    String TranslateKeyOLD = "df-eWU99przz2nag0";
     String TranslateKey = "dfdfgdfg";
    
    Date d1;
    Date d2;
    Date d0;
    int duraction = 3;

//  Speech API Key  AIzaSyDYTSgBZg9Obx5nwJDNPsk_ldYzct2_tnM
//https://github.com/lkuza2/java-speech-api/wiki/Duplex---Hello-World
//  Translate API Key AIzaSyDkETLQ9mpPrQLv6cfX-eWU99przz2nag0
//    http://hayageek.com/google-translate-api-tutorial/
    public SpeechBox(String langFrom, String langTo, int sec) {
        this.langFrom = langFrom;
        this.langTo = langTo;
        this.duraction = sec;
        resFlag = false;
    }

    /*public SpeechBox(String langFrom, String langTo, com.memetix.mst.language.Language MLFrom, com.memetix.mst.language.Language MLTo, int sec, boolean mst) {
        this.langFrom = langFrom;
        this.langTo = langTo;
        this.duraction = sec;
//        this.MLFrom = MLFrom;
//        this.MLTo = MLTo;
        this.mst = mst;
        resFlag = false;
    }
//    com.memetix.mst.language.Language MLFrom;
//    com.memetix.mst.language.Language MLTo;
  
*/  boolean mst = false;
    public void run() {
        SpeechBoxMain();
        resFlag = false;
    }

    public SpeechBox(String langFrom, String langTo, int sec, String speechKey, String transKey) {

        this.langFrom = langFrom;
        this.langTo = langTo;
        this.duraction = sec;
        this.SpeechKey = speechKey;
        this.TranslateKey = transKey;
        
    }
    ResponseObject ro = null;

    public SpeechBox() {

    }

    public ResponseObject getRo() {
        return ro;
    }
    public static String resObj = "Please Wait";
    public static boolean resFlag = false;

    public String SpeechBoxMain() {//working
//        GSpeechDuplex dup = new GSpeechDuplex("AIzaSyAQHVEeuA9tmj9v1mLB-RxpEpC8aKrRnmc");//Instantiate the API
        GSpeechDuplex dup = new GSpeechDuplex(SpeechKey);//Instantiate the API

        dup.addResponseListener(new GSpeechResponseListener() {// Adds the listener
            public void onResponse(GoogleResponse gr) {
                d1 = new Date();
                String res = gr.getResponse();
//                System.out.println("Language Detected: "+dup.getLanguage());
//                System.out.println("Google thinks you said: " + res);
                res = Pick2ndString(res);
                String text = "Try Again";

//                if (mst) {
//                    MSpeechBox msb = new MSpeechBox();
//                    try {
//                        text = msb.mTranslate(MLFrom, MLTo, res);
//                    } catch (Exception ex) {
//                    }
//                }else{

//                javaspeech.GoogleTranslate translator = new javaspeech.GoogleTranslate(TranslateKey);
                try {
//                    text = GoogleTranslate.translate(langFrom, langTo, res);
                    text = new TextTranslator().translate(res, langFrom, langTo);
                } catch (Exception e) {
//                    e.printStackTrace();
                }//}

//                System.out.println("Translated Text: " + text);
                d2 = new Date();
                long sec = ((d2.getTime() - d1.getTime()) / 1000);
                
                if (sec >= 4) {
                    sec = sec - 2;
                }
                ro = new ResponseObject(res, text, sec, (Double.parseDouble(gr.getConfidence()) * 100));
                resFlag = true;
                talk(text);
                //                System.out.println("Time in Seconds: " + (d2.getTime() - d0.getTime()) / 1000);
//                resObj = "<html>You Spoke : " + res + "<br>Translation : " + text + "<br>Confidence : " + (Double.parseDouble(gr.getConfidence()) * 100) + " %" + "<br>Time :" + sec + " Sec</html>";

//                System.out.println("Time in Seconds: " + (sec));

            }
        });
        Microphone mic = new Microphone(FLACFileWriter.FLAC);//Instantiate microphone and have 
        // it record FLAC file.
        File file = new File("CRAudioTest.flac");//The File to record the buffer to. 
        System.out.println("Please Speak");
//        resObj = "Please Speak";
        //You can also create your own buffer using the getTargetDataLine() method.
//        while (true) {
        try {
            mic.captureAudioToFile(file);//Begins recording
            Thread.sleep(duraction * 1000);//Records for 10 seconds
            mic.close();//Stops recording
            System.out.println("Stop Speaking");
            resObj = "Stop Speaking";
            //Sends 10 second voice recording to Google
            byte[] data = Files.readAllBytes(mic.getAudioFile().toPath());//Saves data into memory.
            dup.setLanguage(langFrom);
//            dup.setLanguage("auto");
            dup.recognize(data, (int) mic.getAudioFormat().getSampleRate());
//                    System.out.println("Google Detected language is:"+dup.getLanguage());
            mic.getAudioFile().delete();//Deletes Buffer file
            //REPEAT
        } catch (Exception ex) {
            ex.printStackTrace();//Prints an error if something goes wrong.
        }

//        }
        return resObj;
    }

    public String MstSpeechBoxMain() {//working
//        this.duraction = sec;
//        GSpeechDuplex dup = new GSpeechDuplex("AIzaSyAQHVEeuA9tmj9v1mLB-RxpEpC8aKrRnmc");//Instantiate the API
        GSpeechDuplex dup = new GSpeechDuplex(SpeechKey);//Instantiate the API
        d1 = new Date();
        dup.addResponseListener(new GSpeechResponseListener() {// Adds the listener
            public void onResponse(GoogleResponse gr) {
                d0 = new Date();
                String res = gr.getResponse();
//                System.out.println("Google thinks you said: " + res);
                res = Pick2ndString(res);

                MSpeechBox msb = new MSpeechBox();
//                String mTranslate(Language LangFrom, Language LangTo, String Text)
                String text = " ";
                try {
//                    text = msb.mTranslate(MLFrom, MLTo, res);
                } catch (Exception ex) {
                    Logger.getLogger(SpeechBox.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Translated Text: " + text);
                d2 = new Date();
                long sec = ((d2.getTime() - d1.getTime()) / 1000);
                if (sec >= 4) {
                    sec = sec - 2;
                }
                ro = new ResponseObject(res, text, sec, (Double.parseDouble(gr.getConfidence()) * 100));
                talk(text);
                //                System.out.println("Time in Seconds: " + (d2.getTime() - d0.getTime()) / 1000);
//                resObj = "<html>You Spoke : " + res + "<br>Translation : " + text + "<br>Confidence : " + (Double.parseDouble(gr.getConfidence()) * 100) + " %" + "<br>Time :" + sec + " Sec</html>";

//                System.out.println("Time in Seconds: " + (sec));
                resFlag = true;
            }
        });
        Microphone mic = new Microphone(FLACFileWriter.FLAC);//Instantiate microphone and have 
        // it record FLAC file.
        File file = new File("CRAudioTest.flac");//The File to record the buffer to. 
        System.out.println("Please Speak");
        resObj = "Please Speak";
        //You can also create your own buffer using the getTargetDataLine() method.
//        while (true) {
        try {
            mic.captureAudioToFile(file);//Begins recording
            Thread.sleep(duraction * 1000);//Records for 10 seconds
            mic.close();//Stops recording
            System.out.println("Stop Speaking");
            resObj = "Stop Speaking";
            //Sends 10 second voice recording to Google
            byte[] data = Files.readAllBytes(mic.getAudioFile().toPath());//Saves data into memory.
            dup.setLanguage(langFrom);
            dup.recognize(data, (int) mic.getAudioFormat().getSampleRate());
//                    System.out.println("Google Detected language is:"+dup.getLanguage());
            mic.getAudioFile().delete();//Deletes Buffer file
            //REPEAT
        } catch (Exception ex) {
            ex.printStackTrace();//Prints an error if something goes wrong.
        }

//        }
        return resObj;
    }

    public static void mainInProg(String[] args) {
        GSpeechDuplex dup = new GSpeechDuplex("AIzaSyAQHVEeuA9tmj9v1mLB-RxpEpC8aKrRnmc");//Instantiate the API
        dup.addResponseListener(new GSpeechResponseListener() {// Adds the listener
            public void onResponse(GoogleResponse gr) {
                String res = gr.getResponse();
                System.out.println("Google thinks you said: " + res);
                System.out.println("with "
                        + ((gr.getConfidence() != null) ? (Double.parseDouble(gr.getConfidence()) * 100) : null)
                        + "% confidence.");
                System.out.println("Google also thinks that you might have said:"
                        + gr.getOtherPossibleResponses());
//                talk(gr.getResponse());
                javaspeech.GoogleTranslate translator = new javaspeech.GoogleTranslate("AIzaSyDkETLQ9mpPrQLv6cfX-eWU99przz2nag0");
                String text = translator.translte(res, "hi", "ar");
//        System.out.println(text);
//                System.out.println("Translated Text: "+text);
//                talk(text);

            }
        });
        Microphone mic = new Microphone(FLACFileWriter.FLAC);//Instantiate microphone and have 
        // it record FLAC file.
        File file = new File("CRAudioTest.flac");//The File to record the buffer to. 
        System.out.println("please speak");
        //You can also create your own buffer using the getTargetDataLine() method.
//        while (true) {
        try {
            mic.captureAudioToFile(file);//Begins recording
            Thread.sleep(10000);//Records for 10 seconds
            mic.close();//Stops recording
            //Sends 10 second voice recording to Google
            byte[] data = Files.readAllBytes(mic.getAudioFile().toPath());//Saves data into memory.
            dup.recognize(data, (int) mic.getAudioFormat().getSampleRate());
//                    System.out.println("Google Detected language is:"+dup.getLanguage());
            mic.getAudioFile().delete();//Deletes Buffer file
            //REPEAT
        } catch (Exception ex) {
            ex.printStackTrace();//Prints an error if something goes wrong.
        }

//        } end while
    }

    public static String translateNotWorking(String text) {
        String enableProxy = "false";
        String proxy = "10.11.20.1";
        String port = "8080";
//        String googleTranslateText = "http://translate.google.com.{locale}/translate_a/t?";
        String googleTranslateText1 = "http://translate.google.com.br/translate_a/single?";
        String googleTranslateAudio = "http://translate.google.com/translate_tts?";
        String googleTranslateDetect = "http://www.google.com/uds/GlangDetect?";
        String locale = "pe";
        TranslateEnvironment.init(enableProxy, proxy, port, googleTranslateText1, googleTranslateAudio, googleTranslateDetect, locale);

//        Translator trans = Translator.getInstance();
        String ctext = "hola";
        try {
//            ctext = trans.translate(ctext, "es", "en");
        } catch (Exception ex) {
            System.out.println("Error while TEXT Translation222");
            ex.printStackTrace();
        }

        return ctext;
    }

    public void talk(String text) {
//        text="مانچسٹر کے اولڈ ٹریفورڈ گراؤنڈ میں کھیلے جارہے میچ میں انگلش ٹیم کی جانب سے دیئے گئے پہاڑ جیسے ہدف کے تعاقب میں گرین کیپس کی بیٹنگ جاری ہے";
//text="das ist ein Buch";        
//text="هذا كتاب";        
//String language = "auto";//Uses language autodetection
        //** While the API can detect language by itself, this is reliant on the Google Translate API which is prone to breaking. For maximum stability, please specify the language.**//
        String language = langTo;//English (US) language code   //If you want to specify a language use the ISO code for your country. Ex: en-us
        /*If you are unsure of this code, use the Translator class to automatically detect based off of
    * Either text from your language or your system settings.
         */
        Synthesiser synth = new Synthesiser(language);
        try {
            Audio audio = Audio.getInstance();
            InputStream is = synth.getMP3Data(text);
            audio.play(is);
//            System.out.println("Language: "+synth.detectLanguage(text));
            //TODO Use any Java MP3 Implementation to play back the AudioFile from the InputStream.
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error");
            e.printStackTrace();
            return;
        }
    }

    public static void talk(String text, String lang) {
//String language = "auto";//Uses language autodetection
        //** While the API can detect language by itself, this is reliant on the Google Translate API which is prone to breaking. For maximum stability, please specify the language.**//
//        String language = "ar";//English (US) language code   //If you want to specify a language use the ISO code for your country. Ex: en-us
        String language = lang;//English (US) language code   //If you want to specify a language use the ISO code for your country. Ex: en-us
        /*If you are unsure of this code, use the Translator class to automatically detect based off of
    * Either text from your language or your system settings.
         */
        Synthesiser synth = new Synthesiser(language);
        try {
            Audio audio = Audio.getInstance();
            InputStream is = synth.getMP3Data(text);
            audio.play(is);
//            System.out.println("Language: "+synth.detectLanguage(text));
            //TODO Use any Java MP3 Implementation to play back the AudioFile from the InputStream.
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error");
            e.printStackTrace();
            return;
        }
    }

    public static String Pick2ndString2(String str) {

        String[] speechArrey = str.split(",");
        String speechStr = (speechArrey[0].substring(14)).replace("}", "").replace("\"", "");
//        System.out.println(speechedString);
        return speechStr;
    }

    public static String Pick2ndString(String res) {
//    res = "this is a book I am using a computer\"},{\"transcript\":\"hello this is the book I am using a computer\"},{\"transcript\":\"hello this is a book I am using a computer\"},{\"transcript\":\"this is a book I am using the computer\"},{\"transcript\":\"hello this is the book I am using the computer";
        StringTokenizer st = new StringTokenizer(res, "},{");
        res = st.nextToken();
        res = res.substring(0, res.length() - 1);
//             System.out.println(st.nextToken());  
//        System.out.println("Parsed Res: " + res);
        return res;

    }

    public static void main(String args[]) {
//        String str = "this is a book I am using a computer\"},{\"transcript\":\"hello this is the book I am using a computer\"},{\"transcript\":\"hello this is a book I am using a computer\"},{\"transcript\":\"this is a book I am using the computer\"},{\"transcript\":\"hello this is the book I am using the computer";
//        System.out.println(Pick2ndString(str));
//        SpeechBoxMain();
        SpeechBox sBox = new SpeechBox("en", "ar", 3);
        sBox.SpeechBoxMain();
    }

}
