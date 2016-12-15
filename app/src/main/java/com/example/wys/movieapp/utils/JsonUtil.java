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
            JSONArray actors = tmpObject.getJSONArray("casts");
            String[] actorsArray = new String[actors.length()];
            for (int j = 0; j<actors.length(); j++){
                actorsArray[j] = actors.getJSONObject(j).getString("name");
            }
            model.setId(tmpObject.getString("id"));
            model.setUrl(tmpObject.getString("alt"));
            model.setRating(tmpObject.getJSONObject("rating").getString("average"));
            model.setPubdates(tmpObject.getString("year"));
            model.setSubtype(tmpObject.getString("subtype"));
            model.setComments_count(tmpObject.getInt("collect_count"));
            model.setActors(actorsArray);
            result.add(model);
        }
        return result;
    }

    public static SimpleMovieModel getMovieDetail(String jsonStr, SimpleMovieModel movieModel) throws JSONException {
        JSONObject forecastJson = new JSONObject(jsonStr);
        movieModel.setRatings_count(forecastJson.getInt("ratings_count"));
        movieModel.setIntro(forecastJson.getString("summary"));
        movieModel.setAllInfo(jsonStr);
        return movieModel;
    }

}
