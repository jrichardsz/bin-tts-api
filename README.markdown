# JAVA BING TTS API

This is a  java api which allows you to generate speech from the text entered using bing translator engine, and off course using my lovely java.

## Bing Engine
http://www.bing.com/translator/Default.aspx?mkt=es-es&FORM=R8FD&setplang=es-ES&uid=7F48028A&mkfl=0

## Description

Because my current tts library from google has captcha problems :(, I created this :)

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
public String ttsAppIdUrl = "http://www.bing.com/translator/dynamic/{random_number}/js/LandingPage.js";	
//see "Get appId from Bing" section

//initializing
TTSEnvironment.init( ttsUrl, ttsAppIdUrl);

// this code get response of bing engine as stream
Audio audio = Audio.getInstance();
InputStream sound = audio.getAudio("Buongiorno mondo","it-IT");
audio.play(sound);

```

## Get appId from Bing
According this information : 
http://stackoverflow.com/a/13871282/3957754
http://stackoverflow.com/a/11807881/3957754

Microsoft no longer lets you create appID.

To use the new Bing Search API, you need to use your account key to authenticate. The AppID was the old method of authenticating soon to be deprecated Bing Search API 2.0. 

## Automatic appId extraction
If you are a developer who need a simple text to speech functionality, you could use this approach. But remember that MICROSOFT has a new and powerful api : http://www.bing.com/dev/en-us/speech

##Changelog
See CHANGELOG.markdown for Version History/Changelog

##Credits
See CREDITS.markdown for Credits
