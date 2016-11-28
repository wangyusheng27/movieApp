package com.example.wys.movieapp;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.wys.movieapp.adapter.PictureAdapter;
import com.example.wys.movieapp.model.SimpleMovieModel;
import com.example.wys.movieapp.utils.CommonConstants;
import com.example.wys.movieapp.utils.HttpUtil;
import com.example.wys.movieapp.utils.JsonUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wys on 2016/11/22.
 */
public class MoviePictureFragment extends Fragment {

    PictureAdapter pictureAdapter = null;
    public MoviePictureFragment() {
    }

    @Override
    public void onStart(){
        super.onStart();
        updateMovieInfo();
    }

    private void updateMovieInfo(){
        DouBanApiTask updateMovieInfoTask = new DouBanApiTask();
        updateMovieInfoTask.execute();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        List<SimpleMovieModel> movies = new ArrayList<SimpleMovieModel>();
        this.pictureAdapter = new PictureAdapter(getActivity(), R.layout.grid_item_picture, movies);
        GridView gridView = (GridView) rootView.findViewById(R.id.photo_wall);
        gridView.setAdapter(pictureAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String forecast = arrayAdapter.getItem(position);
//                Intent intent = new Intent(getActivity(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT, forecast);
//                startActivity(intent);
            }
        });
//        FetchWeatherTask weatherTask = new FetchWeatherTask();
//        weatherTask.execute("1816670");
        return rootView;
    }

    class DouBanApiTask extends AsyncTask<String, Void, List<SimpleMovieModel>> {

        @Override
        protected List<SimpleMovieModel> doInBackground(String... strings) {
            String baseUrl = CommonConstants.DOUBAN_API_BASE + CommonConstants.MOVIE_IN_THEATERS;
            final String start = "start";

            Uri builtUri = Uri.parse(baseUrl).buildUpon()
                    .appendQueryParameter(start, "0")
                    .build();
            String result = null;
            try {
                result = HttpUtil.httpGET(builtUri.toString());
            } catch (IOException e) {
                result = "";
                Log.e(DouBanApiTask.class.getSimpleName(), e.toString());
            }
            List<SimpleMovieModel> jsonResult = null;
            try {
                jsonResult = JsonUtil.getMovieData(result);
            } catch (JSONException e) {
                Log.e(DouBanApiTask.class.getSimpleName(), e.toString());
            }
            return jsonResult;
        }

        @Override
        protected void onPostExecute(List<SimpleMovieModel> result) {
            if (result != null){
                pictureAdapter.clear();
                for (SimpleMovieModel res : result){
                    pictureAdapter.add(res);
                }
            }
        }
    }
}
