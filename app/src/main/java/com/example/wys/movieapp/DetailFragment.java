package com.example.wys.movieapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wys.movieapp.model.SimpleMovieModel;
import com.example.wys.movieapp.utils.CommonConstants;
import com.example.wys.movieapp.utils.HttpUtil;
import com.example.wys.movieapp.utils.JsonUtil;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by wys on 2016/12/08.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    private SimpleMovieModel movieModel;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        movieModel = (SimpleMovieModel) intent.getParcelableExtra(Intent.EXTRA_TEMPLATE);
        genView(rootView, movieModel);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        MovieDetailTask task = new MovieDetailTask();
        task.execute();
    }

    private void genView(View rootView, SimpleMovieModel movieModel) {
        TextView name = (TextView) rootView.findViewById(R.id.name);
        name.setText(movieModel.getName());
        ImageView imageView = (ImageView) rootView.findViewById(R.id.detail_small_photo);
        Picasso.with(getActivity()).load(movieModel.getJuzhaoUrl()).into(imageView);
        TextView publish_date = (TextView) rootView.findViewById(R.id.publish_date);
        publish_date.setText(movieModel.getPubdates());
        TextView time = (TextView) rootView.findViewById(R.id.time);
        time.setText("120min");
        TextView rating = (TextView) rootView.findViewById(R.id.rating);
        String ratingText = "豆瓣评分: " + movieModel.getRating() + "/10";
        rating.setText(ratingText);

        TextView rating_amount = (TextView) rootView.findViewById(R.id.rating_amount);
        String ratingAmountText = "评分人数: " + movieModel.getComments_count();
        rating_amount.setText(ratingAmountText);

        TextView actors = (TextView) rootView.findViewById(R.id.actors);
        String actorsName = "演员: " + Arrays.asList(movieModel.getActors()).toString().replaceAll("\\[","").replaceAll("\\]","");
        actors.setText(actorsName);

        if (movieModel.getIntro() != null && !movieModel.getIntro().equals("")) {
            TextView intro = (TextView) rootView.findViewById(R.id.intro);
            intro.setText(movieModel.getIntro());
        }
    }

    class MovieDetailTask extends AsyncTask<String, Void, SimpleMovieModel> {

        @Override
        protected SimpleMovieModel doInBackground(String... strings) {
//            if (!isOnline()) {
//                return null;
//            }
            String baseUrl = CommonConstants.DOUBAN_API_BASE + CommonConstants.MOVIE_DATAIL + "/" + movieModel.getId();

            Uri builtUri = Uri.parse(baseUrl).buildUpon()
                    .build();
            String result = null;
            try {
                result = HttpUtil.httpGET(builtUri.toString());
            } catch (IOException e) {
                result = "";
                Log.e(MoviePictureFragment.DouBanApiTask.class.getSimpleName(), e.toString());
            }
            try {
                movieModel = JsonUtil.getMovieDetail(result, movieModel);
            } catch (JSONException e) {
                Log.e(MoviePictureFragment.DouBanApiTask.class.getSimpleName(), e.toString());
            }
            return movieModel;
        }

        @Override
        protected void onPostExecute(SimpleMovieModel cbd) {
            if (cbd != null) {
                genView(getView(), cbd);
            }
        }

        public boolean isOnline() {
            ConnectivityManager cm =
                    (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        }
    }
}
