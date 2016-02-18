package me.jakir.jsonparsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonParser {

    public static List<Food> parse(String content) {
        try {
            JSONArray array = new JSONArray(content);
            List<Food> foodList = new ArrayList<>();

            for (int i = 0; i < array.length(); i++) {

                JSONObject object = array.getJSONObject(i);
                Food food = new Food();

                food.setName(object.getString("name"));
                food.setPrice(object.getString("price"));
                food.setDescription(object.getString("description"));

                foodList.add(food);

            }
            return foodList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
