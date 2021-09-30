package service.impl.reader;

import beans.IncomeData;
import exception.CustomException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import service.ICustomFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONReader implements ICustomFileReader {
    @Override
    public List<IncomeData> fetchIncomeData(File file) throws CustomException {
        return null;
    }

    @Override
    public Map<String, String> readFileAsKeyValue(String path) throws CustomException {
        String json;
        Map<String, String> jsonMap = new HashMap<>();
        try {
            json = Files.readString(Path.of(path));
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jsonMap.put(jsonObject.getString("currency"), String.valueOf(jsonObject.getDouble("rate")));
            }
        } catch (IOException | JSONException e) {
            throw new CustomException("Exception in converting currency !!!");
        }
        return jsonMap;
    }

}
