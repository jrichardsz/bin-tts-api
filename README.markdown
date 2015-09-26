# JAVA BING TTS API

This is a  java api which allows you to generate speech from the text entered using bing translator engine, and off course using my lovelly java.

## Description

Because my current tts library from google has problems, I created this :)

## Characteristics

  * Use bing engine.

##Features
The api currently provides the following functionality,

  * Simple and fast text to speech (play sound or save to file)
  
The application in the future will provide the following functions

   * Support commandline arguments.

## Usage


```java
//imports
import org.jrichardsz.bing.tts.context.*;
import org.jrichardsz.bing.tts.sound.*;

//required values
String ttsUrl = "http://api.microsofttranslator.com/v2/http.svc/speak?appId={appId}&language={languaje}&format=audio/mp3&options=MinSize|male&text={text}";
public String appId = "TyYTiDGMltI66a4CYYlJ9e23cfF_hgv8zTXuinMoPvoY*";		
//get your appId from microsoft : https://msdn.microsoft.com/en-us/library/dd440736.aspx

//initializing
TTSEnvironment.init( ttsUrl, appId);

// this code get response of bing engine as stream
Audio audio = Audio.getInstance();
InputStream sound = audio.getAudio("Buongiorno mondo","it-IT");
audio.play(sound);

```

## Bing Engine
http://www.bing.com/translator/Default.aspx?mkt=es-es&FORM=R8FD&setplang=es-ES&uid=7F48028A&mkfl=0


##Changelog
See CHANGELOG.markdown for Version History/Changelog

##Credits
See CREDITS.markdown for Credits
