package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

//Websocket client that communicates with speech/translate api 
@WebSocket*/
public class SpeechTranslationSessionSocket {/*
      private final byte[] silenceBytes = new byte[32000];
      private final CountDownLatch closeLatch;

      private String inputAudioFileName;

      @SuppressWarnings("unused")
      private Session session;

      public SpeechTranslationSessionSocket(String inputAudioFileName) {
            this.inputAudioFileName = inputAudioFileName;
            this.closeLatch = new CountDownLatch(1);
      }

      public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
            return this.closeLatch.await(duration, unit);
      }

      @OnWebSocketClose
      public void onClose(int statusCode, String reason) {
            System.out.printf("[%s] Connection closed: %d - %s%n", LocalDateTime.now().toString(), statusCode, reason);
            this.session = null;
            this.closeLatch.countDown();
      }

      @OnWebSocketConnect
      public void onConnect(Session session) {
            System.out.printf("[%s] Connection Success: %s%n", LocalDateTime.now().toString(), session);
            this.session = session;
            try {
                  // start streaming the audio
                  sendData(session, inputAudioFileName);
                  System.out.printf("%n[%s] Done streaming audio.%n", LocalDateTime.now().toString());
            } catch (Throwable t) {
                  t.printStackTrace();
            }
      }

      @OnWebSocketMessage
      public void onMessage(String msg) {

            System.out.printf("[%s] Message Received: %s%n", LocalDateTime.now().toString(), msg);
      }

      private void sendData(Session session, String fileName) {
            try {
                  try (FileInputStream fi = new FileInputStream(new File(fileName))) {
                        byte[] buffer = new byte[32000];
                        int counter = 0;
                        System.out.printf("[%s] Sending Bytes: ", LocalDateTime.now().toString());
                        while ((counter = fi.read(buffer, 0, buffer.length)) != -1) {
                              if (counter > 0) {
                                    System.out.printf(".");
                                    session.getRemote().sendBytes(ByteBuffer.wrap(buffer));
                                    Thread.sleep(100);
                              }
                        }
                  }

                  // Now send some silence bytes
                  for (int i = 0; i < 10; i++) {
                        session.getRemote().sendBytes(ByteBuffer.wrap(silenceBytes));
                        Thread.sleep(100);
                  }
            } catch (Exception e) {
                  e.printStackTrace();
                  System.exit(1);
            }
      }
*/}
