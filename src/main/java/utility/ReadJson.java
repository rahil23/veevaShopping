package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public Map readJson(String path) {

		//String path = System.getProperty("user.dir") + "//testData.json";
		FileReader reader = null;
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(reader);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(json.toJSONString());
		JSONArray testDetails = (JSONArray) json.get("testDetails");
		JSONObject testData = (JSONObject) testDetails.get(0);
		System.out.println(testData.toJSONString());
		JSONArray data = (JSONArray) testData.get("testData");
		System.out.println(data.toJSONString());

		JSONObject testDataSet = (JSONObject) data.get(0);
		String url = (String) testDataSet.get("url");
		System.out.println(url);

		String browser = (String) testDataSet.get("browser");
		System.out.println(browser);

		HashMap<String, String> testDataJson = new HashMap();
		testDataJson.put("url", url);
		testDataJson.put("browser", browser);

		return testDataJson;

	}

}
