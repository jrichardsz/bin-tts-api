package org.jrichardsz.bing.tts.context;

public class TranslateEnvironment {

    public static void init(String translateAudioUrl,String yandexAppId)
	{
    	
    	System.getProperties().put(Const.TRANSLATE_AUDIO_URL,translateAudioUrl);
    	System.getProperties().put(Const.TRANSLATE_AUDIO_APPID,yandexAppId);
    	
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
