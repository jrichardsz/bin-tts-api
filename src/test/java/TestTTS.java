import java.io.*;

import org.jrichardsz.bing.tts.context.*;
import org.jrichardsz.bing.tts.sound.*;
import org.junit.*;

public class TestTTS {

	public String ttsUrl = "http://api.microsofttranslator.com/v2/http.svc/speak?appId={appId}&language={languaje}&format=audio/mp3&options=MinSize|male&text={text}";
	public String ttsAppIdUrl = "http://www.bing.com/translator/dynamic/{random_number}/js/LandingPage.js";
		
	@Test
	public void testPlay() throws Exception {

		TTSEnvironment.init( ttsUrl, ttsAppIdUrl);

		Audio audio = Audio.getInstance();
		InputStream sound = audio.getAudio("Buongiorno mondo","it-IT");
        audio.play(sound);

	}

}
