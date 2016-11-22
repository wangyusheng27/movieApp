package com.example.wys.movieapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wys on 2016/11/22.
 */
public class MoviePictureFragment extends Fragment {

    ArrayAdapter<ImageView> arrayAdapter = null;

    public MoviePictureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        List<ImageView> temperatures = new ArrayList<>();
        this.arrayAdapter = new ArrayAdapter<ImageView>(getActivity(), R.layout.grid_item_picture, R.id.grid_item_picture_imageView, temperatures);
        GridView gridView = (GridView) rootView.findViewById(R.id.photo_wall);
        gridView.setAdapter(arrayAdapter);
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
