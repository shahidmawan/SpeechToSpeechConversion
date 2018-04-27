package com.gtranslate;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.gtranslate.parsing.Parse;
import com.gtranslate.parsing.ParseTextDetect;
import com.gtranslate.parsing.ParseTextTranslate;
import com.gtranslate.text.Text;
import com.gtranslate.text.TextTranslate;

public class Translator {
	
	private static Translator translator;


	public synchronized static Translator getInstance() {

		if (translator == null) {
			translator = new Translator();
		}
		return translator;

	}

	public void translate(TextTranslate textTranslate) throws Exception {

		Parse parse = new ParseTextTranslate(textTranslate);
		parse.parse();

	}

	public String translateAsJsonString(String text, String languageInput, String languageOutput) throws Exception {

		Text input = new Text(text, languageInput);
		TextTranslate textTranslate = new TextTranslate(input, languageOutput);
		Parse parse = new ParseTextTranslate(textTranslate);
		parse.parse();
		return textTranslate.getOutput().getText();

	}
	
	public JSONArray translateAsJsonArray(String text, String languageInput, String languageOutput) throws Exception {
		
		String strTransJson = translateAsJsonString(text, languageInput, languageOutput); 
		
		return parseStringToJsonArrayObject(strTransJson);
	}
	
	public JSONArray parseStringToJsonArrayObject(String strTransJson) throws Exception {
		
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(strTransJson);
		
		return jsonArray;
	}
	
	public String translate(String text, String languageInput, String languageOutput) throws Exception {

		JSONArray jsonArrayGoogleResponse = translateAsJsonArray(text, languageInput, languageOutput);
		
		return extractPayloadTranslationFromJsonArrayObject(jsonArrayGoogleResponse);

	}
	
	/* JSONArray jsonArrayGoogleResponse is : 
	 * [[["hello","hola","",""]],,"es",,[["hello",[1],true,false,550,0,1,0]],[["hola",1,[["hello",550,true,false],["hi",449,true,false],["Hola",0,true,false],["Hey",0,true,false]],[[0,4]],"hola"]],,,[["es"]],15]
	 */
	public String extractPayloadTranslationFromJsonArrayObject(JSONArray jsonArrayGoogleResponse) throws Exception {
		
		JSONArray element1 = (JSONArray) jsonArrayGoogleResponse.get(0);
		JSONArray element1_1 = (JSONArray) element1.get(0);
		
		String elementTranslate = (String) element1_1.get(0);
		
		return elementTranslate;

	}

	public String detect(String text) throws Exception {

		Text input = new Text(text);
		Parse parse = new ParseTextDetect(input);
		parse.parse();
		return input.getLanguage();

	}

}
