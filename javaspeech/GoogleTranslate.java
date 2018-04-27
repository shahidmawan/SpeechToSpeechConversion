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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
/**
 *
 * @author Ravishanker Kusuma
 */
public class GoogleTranslate {
 
    private String key;
 
    public GoogleTranslate(String apiKey) {
        key = apiKey;
    }
 
    String translte(String text, String from, String to) {
        StringBuilder result = new StringBuilder();
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");
            String urlStr = "https://www.googleapis.com/language/translate/v2?key=" + key + "&q=" + encodedText + "&target=" + to + "&source=" + from;
 
            URL url = new URL(urlStr);
 
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            InputStream stream;
            if (conn.getResponseCode() == 200) //success
            {
                stream = conn.getInputStream();
            } else
                stream = conn.getErrorStream();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
 
            JsonParser parser = new JsonParser();
 
            JsonElement element = parser.parse(result.toString());
 
            if (element.isJsonObject()) {
                JsonObject obj = element.getAsJsonObject();
                if (obj.get("error") == null) {
                    String translatedText = obj.get("data").getAsJsonObject().
                    get("translations").getAsJsonArray().
                    get(0).getAsJsonObject().
                    get("translatedText").getAsString();
                    return translatedText;
 
                }
            }
 
            if (conn.getResponseCode() != 200) {
                System.err.println(result);
            }
 
        } catch (IOException | JsonSyntaxException ex) {
            System.err.println(ex.getMessage());
        }
 
        return null;
    }
    public static void main(String[] args) {
 // pa=punjabi, ms=malay, ar=arabic, en=english, hi=hindi, ur=urdu
        GoogleTranslate translator = new GoogleTranslate("AIzaSyDkETLQ9mpPrQLv6cfX-eWU99przz2nag0");
//        String text = translator.translte("How are you. I am fine", "en", "pa");
//        String text = translator.translte("Apa khabar Saya denda", "ms", "ar");
//        String text1 = translator.translte("main theek hoon, aap kaise hain", "en", "ar");
        String text1 = translator.translte("flight has taken off on time", "en", "ur");
//        String text1 = translator.translte("آپ کیسے ہیں. میں ٹھیک ہوں", "ur", "hi");
//        String text2 = translator.translte("كيف حالك. انا بخير", "ar", "hi");
//        String text3 = translator.translte("क्या हाल है। मैं ठीक हूँ", "hi", "ar");
//        System.out.println(text);
//        System.out.println(text1);
        System.out.println(text1);
//        SpeechBox.talk(text);
//        SpeechBox.talk(text,"auto");
    }
}
