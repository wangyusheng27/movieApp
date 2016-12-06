package com.example.wys.movieapp.utils;

import com.example.wys.movieapp.model.SimpleMovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wys on 2016/11/28.
 */
public class JsonUtil {
    public static ArrayList<SimpleMovieModel> getMovieData(String jsonStr) throws JSONException {
        ArrayList<SimpleMovieModel> result = new ArrayList<SimpleMovieModel>();
        JSONObject forecastJson = new JSONObject(jsonStr);
        JSONArray movieInfo = forecastJson.getJSONArray("subjects");
        for (int i = 0; i < movieInfo.length(); i++) {
            JSONObject tmpObject = movieInfo.getJSONObject(i);
            SimpleMovieModel model = new SimpleMovieModel(tmpObject.getJSONObject("images").getString("large"), tmpObject.getString("title"));
            result.add(model);
        }
        return result;
    }
}
