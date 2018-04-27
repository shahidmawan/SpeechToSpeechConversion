package com.gtranslate.test;

import java.io.*;

import org.junit.*;

import com.gtranslate.*;
import com.gtranslate.context.*;

public class TestTTS {

	public String enableProxy = "false";
	public String proxy = "my.proxy.com";
	public String port= "8080";
	public String googleTranslateText = "http://translate.google.com.{locale}/translate_a/t?";
	public String googleTranslateAudio = "http://translate.google.com/translate_tts?";
	public String googleTranslateDetect = "http://www.google.com/uds/GlangDetect?";
	public String locale = "pe";		
		
	@Test
	public void testPlay() throws Exception {

		TranslateEnvironment.init(enableProxy, proxy, port, googleTranslateText, googleTranslateAudio, googleTranslateDetect, locale);
		
		Audio audio = Audio.getInstance();
		InputStream sound = audio.getAudio("Hello Richard","en");
        audio.play(sound);
	
	}
	
	@Test
	public void testFile() throws Exception {

		TranslateEnvironment.init(enableProxy, proxy, port, googleTranslateText, googleTranslateAudio, googleTranslateDetect, locale);
		
		Audio audio = Audio.getInstance();
		InputStream sound = audio.getAudio("Hola Richard","es");
        
		OutputStream out =  new FileOutputStream(new File("test_file.mp3"));
//		IOUtils.copy(sound,out);
	
	}	
	


}
