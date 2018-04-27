/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.api.translate;

import com.google.api.GoogleAPI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahid
 */
public class TextTranslator {
	private static final long serialVersionUID = 7916697355146649532L;
	private Translate translate;
    public TextTranslator()  {
        
        translate = Translate.DEFAULT;
        
        GoogleAPI.setKey("AIzaSyC_oOS8KXtRBDKNF7e8e5UHrlhAa77Pbk8");
        GoogleAPI.setHttpReferrer("www.kics.edu.pk");
    }
    
    public String translate(String text, String langFrom, String langTo) {
        try {
            return translate.execute(text, Language.fromString(langFrom), Language.fromString(langTo));
        } catch (Exception ex) {
            Logger.getLogger(TranslatorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}
