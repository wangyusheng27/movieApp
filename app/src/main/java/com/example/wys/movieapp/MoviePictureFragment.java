package com.example.wys.movieapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.wys.movieapp.adapter.PictureAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wys on 2016/11/22.
 */
public class MoviePictureFragment extends Fragment {

    PictureAdapter pictureAdapter = null;
    ArrayAdapter<String> arrayAdapter = null;
    public MoviePictureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        List<String> temperatures = new ArrayList<>();
        temperatures.add("http://i.imgur.com/DvpvklR.png1");
        temperatures.add("http://i.imgur.com/DvpvklR.png2");
        temperatures.add("http://i.imgur.com/DvpvklR.png3");
        this.pictureAdapter = new PictureAdapter(getActivity(), R.layout.grid_item_picture, temperatures);
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
}
