package com.gtranslate;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import com.gtranslate.context.Const;
import com.gtranslate.context.TranslateEnvironment;

public class Audio {
	private static Audio audio;

	public synchronized static Audio getInstance() {

		if (audio == null) {
			audio = new Audio();
		}
		return audio;
	}

	public InputStream getAudio(String text, String languageOutput)
			throws Exception {
		
		URL url = new URL(TranslateEnvironment.getSystemProperty(Const.GOOGLE_TRANSLATE_AUDIO) + "q="+ text.replace(" ", "%20") + "&tl=" + languageOutput);
		URLConnection urlConn = url.openConnection();
		urlConn.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		InputStream audioSrc = urlConn.getInputStream();
		return new BufferedInputStream(audioSrc);
	}

	public void play(InputStream sound) throws JavaLayerException {
		new Player(sound).play();
	}

}
