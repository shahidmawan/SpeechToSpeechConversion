package com.gtranslate.parsing;

import com.gtranslate.context.Const;
import com.gtranslate.context.TranslateEnvironment;
import com.gtranslate.text.Text;
import com.gtranslate.utils.WebUtils;

public class ParseTextDetect implements Parse {
	
	private StringBuilder stbUrl;	
	private Text input;
	

	public ParseTextDetect(Text input) {
		this.input = input;
	}

	
	public void appendURL() throws Exception {

		stbUrl = new StringBuilder(TranslateEnvironment.getSystemProperty(Const.GOOGLE_TRANSLATE_DETECT));
		stbUrl.append("v=1.0&");
		stbUrl.append("q=" + input.getLanguage().replace(" ", "%20"));

	}

	
	public void parse() throws Exception {

		appendURL();
		String result = WebUtils.source(stbUrl.toString());
		input.setLanguage(result.split(",")[0].split(":")[2].replace("\"", ""));

	}

}
