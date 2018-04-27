/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtranslate.utils;

/**
 *
 * @author http://code.google.com/p/java-google-translate-text-to-speech/
 * Modification by : Richard Osmar Leon Ingaruca - RNASystems
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import com.gtranslate.context.Const;
import com.gtranslate.context.TranslateEnvironment;


public class WebUtils {

        public static String source(String urlSite) throws Exception {
                StringBuilder result = new StringBuilder();

                URL url;
                URLConnection urlConn;

                try {
                        url = new URL(urlSite);
                        urlConn = getURLConnection(url);                     
//                      urlConn.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                        urlConn.addRequestProperty("User-Agent","Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
                        Reader reader = new InputStreamReader(urlConn.getInputStream(),"utf-8");
                        BufferedReader br = new BufferedReader(reader);

                        int byteRead;
                        while ((byteRead = br.read()) != -1)
                                result.append((char) byteRead);

					}catch (Exception e) {
						throw new Exception("Error when try to read stream from ["+urlSite+"]",e);
					}
                return result.toString();
        }
        
    // method that enables the use of proxies in the Google Translate API  
    private static URLConnection getURLConnection(URL url) throws Exception{
       
        try{            
                   
	        if(Boolean.valueOf(TranslateEnvironment.getSystemProperty(Const.ENABLE_PROXY))){
	        	
	             Proxy prox = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(TranslateEnvironment.getSystemProperty(Const.PROXY),Integer.parseInt(TranslateEnvironment.getSystemProperty(Const.PORT))));           
	             return url.openConnection(prox);
	        	             
	        }else {
	        	return url.openConnection();
	        }
	        
        }catch(Exception e){
            throw new Exception("Error when try to stabilish conection to : ["+url.getPath()+"]",e);
        } 
    }        

}


