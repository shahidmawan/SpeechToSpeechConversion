/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

/**
 *
 * @author Shahid
 */
//import com.memetix.mst.language.Language;
//import com.memetix.mst.language.SpokenDialect;
//import com.memetix.mst.speak.Speak;
//import com.memetix.mst.translate.Translate;
import java.util.Properties;

public class MSpeechBox {
//Properties p;
/*
    public static void main(String[] args) throws Exception {
        MSpeechBox msb = new MSpeechBox();
        String translatedText = msb.mTranslate2("", "", "");
        System.out.println(translatedText);
        Speak.setKey("/jRgzn5rPVfWMHo+98ygOhvqaY75Q5BjVEeFvbAvP08=");
        Speak.setClientSecret("/jRgzn5rPVfWMHo+98ygOhvqaY75Q5BjVEeFvbAvP08=");
        Speak.setClientId("SpeechBoxPro");
        msb.Speak(SpokenDialect.ENGLISH_INDIA, translatedText);
        msb.testGetSpeakUrl();
        msb.testGetSpeakUrlUk();
    }

    public String mTranslate(Language LangFrom, Language LangTo, String Text) throws Exception {
        // Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
        Translate.setClientId("SpeechBoxPro");
        Translate.setClientSecret("/jRgzn5rPVfWMHo+98ygOhvqaY75Q5BjVEeFvbAvP08=");
        String translatedText = Translate.execute(Text, LangFrom, LangTo);
//        System.out.println("Microsoft returned : " + translatedText);
        return translatedText;
    }

    public String mTranslate2(String LangFrom, String LangTo, String Text) throws Exception {
        // Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
        Translate.setClientId("SpeechBoxPro");
        Translate.setClientSecret("/jRgzn5rPVfWMHo+98ygOhvqaY75Q5BjVEeFvbAvP08=");
        String translatedText = Translate.execute("Bonjour le monde, gourmet, uptown la, bon vivant", Language.FRENCH, Language.ENGLISH);
        return translatedText;
    }

    public void testGetSpeakUrl() throws Exception {
        Speak.setKey("/jRgzn5rPVfWMHo+98ygOhvqaY75Q5BjVEeFvbAvP08=");
        Speak.setClientId("SpeechBoxPro");
        String text = "Hello World!";
        SpokenDialect language = SpokenDialect.ENGLISH_INDIA;
        String expResult = "http://api.microsofttranslator.com/V2/http.svc/Speak";
        String result = Speak.execute(text, language);
//        assertEquals(true, result.contains(expResult));
    }

    public void testGetSpeakUrlUk() throws Exception {
        String text = "Hello World!";
        SpokenDialect language = SpokenDialect.ENGLISH_UNITED_KINGDOM;
        String expResult = "http://api.microsofttranslator.com/V2/http.svc/Speak";
        String result = Speak.execute(text, language);
//        assertEquals(true, result.contains(expResult));
    }

    public void Speak(SpokenDialect language1, String text) throws Exception {
        SpokenDialect.setKey("/jRgzn5rPVfWMHo+98ygOhvqaY75Q5BjVEeFvbAvP08=");
//        SpokenDialect.setKey(null);
//        String text = "Hello World!";
        SpokenDialect language = SpokenDialect.ENGLISH_INDIA;
        String expResult = "http://api.microsofttranslator.com/V2/http.svc/Speak";
        String result = Speak.execute(text, language);
//        assertEquals(true, result.contains(expResult));
    }
*/
}
