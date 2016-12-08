package com.example.wys.movieapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wys on 2016/12/08.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int i = 1;
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        TextView textView = (TextView) rootView.findViewById(R.id.detail_text);
        textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        return rootView;
    }

}
