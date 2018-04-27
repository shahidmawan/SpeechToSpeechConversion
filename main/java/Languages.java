import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class Languages {

      final String charset = StandardCharsets.UTF_8.name();
      final String getLanguageUrl = "https://dev.microsofttranslator.com/languages?api-version=1.0";

      public static void main(String[] args) {
            Languages languageClient = new Languages();
            LanguageList supportedLanguages = languageClient.getLanguages("speech,text,tts");
            Languages.printSpeechLanguages(supportedLanguages.speech);
            Languages.printTextLanguages(supportedLanguages.text);
            Languages.printTtsLanguages(supportedLanguages.tts);
      }

      private LanguageList getLanguages(String scope) {
            try {
                  URL url = new URL(getLanguageUrl);
                  if (scope != null && !scope.isEmpty()) {
                        String query = String.format("&scope=%s", scope);
                        url = new URL(getLanguageUrl + query);
                  }

                  HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                  if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        // OK
                        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                              StringBuffer res = new StringBuffer();
                              String line;
                              while ((line = reader.readLine()) != null) {
                                    res.append(line);
                              }
                              Gson gson = new Gson();
                              LanguageList languages = gson.fromJson(res.toString(), LanguageList.class);
                              return languages;
                        }

                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return null;
      }

      public static void printSpeechLanguages(Map<String, LanguageInfo> speechLanguages) {
            if (speechLanguages != null) {
                  System.out.println("\nSupported Speech Languages:");
                  for (Map.Entry<String, LanguageInfo> entry : speechLanguages.entrySet()) {
                        LanguageInfo tempLang = entry.getValue();
                        System.out.println(String.format("SpeechLocale: %s Name: %s LanguageCode: %s", entry.getKey(),
                                    tempLang.name, tempLang.code));
                  }
            }
      }

      public static void printTextLanguages(Map<String, LanguageInfo> textLanguages) {
            if (textLanguages != null) {
                  System.out.println("\nSupported text Languages:");
                  for (Map.Entry<String, LanguageInfo> entry : textLanguages.entrySet()) {
                        LanguageInfo tempLang = entry.getValue();
                        System.out.println(String.format("LanguageCode: %s Name: %s Direction: %s", entry.getKey(),
                                    tempLang.name, tempLang.dir));
                  }
            }
      }

      public static void printTtsLanguages(Map<String, TtsLanguage> ttsLanguages) {
            if (ttsLanguages != null) {

                  System.out.println("\nSupported TTS Languages:");

                  for (Map.Entry<String, TtsLanguage> entry : ttsLanguages.entrySet()) {
                        TtsLanguage tempLang = entry.getValue();
                        System.out.println(String.format(
                                    "LanguageVoice: %s LanguageName: %s Locale: %s DisplayName: %s Region: %s ", entry.getKey(),
                                    tempLang.languageName, tempLang.locale, tempLang.displayName, tempLang.regionName));
                  }
            }
      }

      class LanguageList {
            public Map<String, LanguageInfo> speech;
            public Map<String, LanguageInfo> text;
            public Map<String, TtsLanguage> tts;
      }

      public class LanguageInfo {
            public String code;
            public String name;
            public String dir;
      }

      public class TtsLanguage {
            public String Gender;
            public String locale;
            public String languageName;
            public String displayName;
            public String regionName;
            public String language;
      }
}

