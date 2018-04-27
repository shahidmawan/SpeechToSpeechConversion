import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

//Class to get access token from Azure Data market
public class AdmAccessToken 
{
    public String access_token;
    public String token_type;
    public String expires_in;
    public String scope;
    
    public static AdmAccessToken getAccessToken(String clientId, String clientSecret)
	{
		AdmAccessToken accessToken = null;
		try
		{
			String charset = StandardCharsets.UTF_8.name(); 
			String dataMarketUrl = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";
			String params = "grant_type=client_credentials&scope=http://api.microsofttranslator.com"
	                + "&client_id=" + URLEncoder.encode(clientId, charset)
	                + "&client_secret=" + URLEncoder.encode(clientSecret, charset) ;
	        URL url = new URL(dataMarketUrl);
		
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=" + charset);
	        connection.setRequestProperty("Accept-Charset",charset);
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        try(OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream()))
	        {
	        	wr.write(params);
	        	wr.flush();
	        }
	        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) 
	        {
	            // OK
	        	try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset)))
		        {
		            StringBuffer res = new StringBuffer(); 
		            String line;
		            while ((line = reader.readLine()) != null) 
		            {
		                res.append(line);
		            }
		          
		            //Json deserialize the access token 
		            Gson gson = new Gson();
		            accessToken = gson.fromJson(res.toString(), AdmAccessToken.class);
	        	}
	        }     
	 	} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return accessToken;
	}
}