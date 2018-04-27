package com.gtranslate.context;

public class TranslateEnvironment {

    public static void init(String enableProxy, String proxy, String port, String googleTranslateText, String googleTranslateAudio,String googleTranslateDetect,String locale)
	{
    	
    	System.getProperties().put(Const.ENABLE_PROXY,enableProxy);
    	System.getProperties().put(Const.PROXY,proxy);
    	System.getProperties().put(Const.PORT,port);
    	System.getProperties().put(Const.GOOGLE_TRANSLATE_TEXT,googleTranslateText);
    	System.getProperties().put(Const.GOOGLE_TRANSLATE_AUDIO,googleTranslateAudio);
    	System.getProperties().put(Const.GOOGLE_TRANSLATE_DETECT,googleTranslateDetect);
    	System.getProperties().put(Const.LOCALE,locale);
    	
    	
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
