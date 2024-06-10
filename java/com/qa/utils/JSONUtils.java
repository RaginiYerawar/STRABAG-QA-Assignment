package com.qa.utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtils {

	public static JSONObject parseJSONFile(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        return (JSONObject) jsonParser.parse(reader);
    }
}
