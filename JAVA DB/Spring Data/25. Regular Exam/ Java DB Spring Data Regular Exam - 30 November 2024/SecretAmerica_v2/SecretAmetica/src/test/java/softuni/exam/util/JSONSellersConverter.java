package softuni.exam.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONSellersConverter {
    public static void main(String[] args) throws IOException {
        try {
            String json = Files.readString(Paths.get("src/main/resources/files/json/attractions.json"));
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String description = jsonObject.getString("description");
                String type = jsonObject.getString("type");
                int elevation = Integer.parseInt(jsonObject.getString("elevation"));
                int country_id = Integer.parseInt(jsonObject.getString("country"));
                System.out.printf(
                        "\"  {\\n\" +\n" +
                                "\"    \\\"name\\\": \\\"%s\\\",\\n\" +\n" +
                                "\"    \\\"description\\\": \\\"%s\\\",\\n\" +\n" +
                                "\"    \\\"type\\\": \\\"%s\\\",\\n\" +\n" +
                                "\"    \\\"elevation\\\": \\\"%d\\\",\\n\" +\n" +
                                "\"    \\\"country\\\": \\\"%d\\\"\\n\" +\n" +
                                "\"  },\\n\" +\n",
                        name, description, type, elevation, country_id);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
