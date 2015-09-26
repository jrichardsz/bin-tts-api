package org.jrichardsz.bing.tts.context;

import org.jrichardsz.bing.tts.appid.*;

public class TTSEnvironment {

    public static void init(String ttsUrl,String appidUrl) throws Exception
	{
    	
    	System.getProperties().put(Const.TTS_URL,ttsUrl);
    	System.getProperties().put(Const.TTS_APPID_URL,appidUrl);
    	System.getProperties().put(Const.TTS_APPID, new AppIdExtractor().getAppId(appidUrl));
    	
	}
    
    public static final String getSystemProperty(String key, String def) throws Exception
    {
        String value = System.getProperty(key, def);
        
        if(value==null){
        	throw new Exception("Error when try to get property["+key+"] from java.lang.System");
        }
        
        return value;
    }
    
    public static final String getSystemProperty(String key) throws Exception
    {
        return getSystemProperty(key, null);
    }    

}
