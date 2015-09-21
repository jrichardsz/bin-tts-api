

import java.io.*;

import org.jrichardsz.bing.tts.context.*;
import org.jrichardsz.bing.tts.sound.*;
import org.junit.*;

public class TestTTS {

	public String translateAudioUrl = "http://api.microsofttranslator.com/v2/http.svc/speak?appId={appId}&language={languaje}&format=audio/mp3&options=MinSize|male&text={text}";
	public String appId = "TyYTiDGMltI66a4CYYlJ9e23cfF_hgv8zTXuinMoPvoY*";		
		
	@Test
	public void testPlay() throws Exception {

		TranslateEnvironment.init( translateAudioUrl, appId);

		Audio audio = Audio.getInstance();
		InputStream sound = audio.getAudio("Buongiorno mondo","it-IT");
        audio.play(sound);

	}

}
