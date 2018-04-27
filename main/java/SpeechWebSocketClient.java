package main.java;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
/*
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
*/
public class SpeechWebSocketClient {/*
      private static final String speechTranslateUriTemplate = "wss://dev.microsofttranslator.com/speech/translate?from=%1s&to=%2s&api-version=1.0";

      private static String generateWsUrl(String from, String to) {
            return String.format(speechTranslateUriTemplate, from, to);
      }

      public static void main(String[] args) {
//			if (args.length != 3){
//				System.out.println("Input the following Parameters:\nClientId ClientSecret AudioFile");
//				return;
//			}
//		
//			AdmAccessToken accessToken = AdmAccessToken.getAccessToken(args[0], args[1]);
//			SslContextFactory sslContextFactory = new SslContextFactory();
//			WebSocketClient client = new WebSocketClient(sslContextFactory);
//			String inputAudioFile = args[2];
//			SpeechTranslationSessionSocket socket = new SpeechTranslationSessionSocket(inputAudioFile);
//		  
//            try {
//                  String from = "en-us";
//                  String to = "fr-fr";
//                  String traceId = UUID.randomUUID().toString();
//
//                  ClientUpgradeRequest request = new ClientUpgradeRequest();
//                  request.setHeader("Authorization", "Bearer " + accessToken.access_token);
//                  request.setHeader("X-ClientTraceId", traceId);
//                  
//                  // Authorization headers does not set the right property in the
//                  // server so pass the access token in url
//                  String speechTranslateUri = generateWsUrl(from, to);
//
//                  client.start();
//                  URI echoUri = new URI(speechTranslateUri);
//                  client.connect(socket, echoUri, request);
//                  System.out.printf("[%s] Connecting to : %s%n", LocalDateTime.now().toString(), echoUri);
//                  System.out.println("ClientTraceId: " + traceId);
//                  // wait enough so the server has ample time to respond
//                  socket.awaitClose(30, TimeUnit.SECONDS);
//            } catch (Throwable t) {
//                  t.printStackTrace();
//            } finally {
//                  try {
//                        client.stop();
//                  } catch (Exception e) {
//                        e.printStackTrace();
//                  }
//            }
      }
*/}

