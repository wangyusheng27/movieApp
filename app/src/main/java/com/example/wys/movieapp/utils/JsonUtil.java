package com.example.wys.movieapp.utils;

import com.example.wys.movieapp.model.SimpleMovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wys on 2016/11/28.
 */
public class JsonUtil {
    public static List<SimpleMovieModel> getMovieData(String jsonStr) throws JSONException {
        List<SimpleMovieModel> result = new ArrayList<SimpleMovieModel>();
        JSONObject forecastJson = new JSONObject(jsonStr);
        JSONArray movieInfo = forecastJson.getJSONArray("subjects");
        for (int i = 0; i < movieInfo.length(); i++){
            JSONObject tmpObject = movieInfo.getJSONObject(i);
            SimpleMovieModel model = new SimpleMovieModel();
            model.setName(tmpObject.getString("title"));
            model.setJuzhaoUrl(tmpObject.getJSONObject("images").getString("large"));
            result.add(model);
        }
        return result;
    }
}
