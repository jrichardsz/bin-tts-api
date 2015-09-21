package org.jrichardsz.bing.tts.sound;

import java.io.*;
import java.net.*;

import org.jrichardsz.bing.tts.context.*;

import javazoom.jl.decoder.*;
import javazoom.jl.player.*;

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
		
		String urlString = TranslateEnvironment.getSystemProperty(Const.TRANSLATE_AUDIO_URL);
		urlString= urlString.replace("{appId}", TranslateEnvironment.getSystemProperty(Const.TRANSLATE_AUDIO_APPID));
		urlString= urlString.replace("{languaje}",languageOutput);
		urlString= urlString.replace("{text}",text.replace(" ","%20"));
		
		URL url = new URL(urlString);
		URLConnection urlConn = url.openConnection();
		urlConn.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		InputStream audioSrc = urlConn.getInputStream();
		return new BufferedInputStream(audioSrc);
	}

	public void play(InputStream sound) throws JavaLayerException {
		new Player(sound).play();
	}

}
