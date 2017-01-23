package com.alexnevsky.facemash.utils;

import com.alexnevsky.facemash.model.Face;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * User: Alex Nevsky
 * Date: 16.11.13
 */
public class FacebookHelper {

	private static final String GRAPH_URL = "https://graph.facebook.com/";
	private static final String GRAPH_QUERY_FIELDS = "?fields=gender,picture.height(317).width(214)," +
			"first_name,last_name&locale=en_GB";

	public static String getUserBasicData(String facebookId) {
		String result = null;

		try {
			String graphQuery = GRAPH_URL + facebookId + GRAPH_QUERY_FIELDS;

			URLConnection connection = new URL(graphQuery).openConnection();
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			InputStream response = connection.getInputStream();

			BufferedReader rd = new BufferedReader(new InputStreamReader(response));
			StringBuilder sb = new StringBuilder(512);
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();

			result = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static Face makeFaceFromBasicUserData(String data) {
		Face face = null;

		if (data != null) {
			try {
				JSONObject json = (JSONObject) new JSONParser().parse(data);

				String id = json.get("id").toString();
				String firstName = json.get("first_name").toString();
				String lastName = json.get("last_name").toString();
				String gender = json.get("gender").toString();

				JSONObject picture = (JSONObject) new JSONParser().parse(json.get("picture").toString());
				JSONObject pictureData = (JSONObject) new JSONParser().parse(picture.get("data").toString());

				String pictureUrl = pictureData.get("url").toString();

				face = new Face(Long.valueOf(id), firstName, lastName, gender, pictureUrl);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return face;
	}
}
