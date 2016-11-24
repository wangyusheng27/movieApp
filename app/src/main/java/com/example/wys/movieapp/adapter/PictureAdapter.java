package com.example.wys.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.wys.movieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wys on 2016/11/24.
 */

public class PictureAdapter extends ArrayAdapter<String>{

    protected LayoutInflater mInflater;
    protected int res ;


    public PictureAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        res = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        if (convertView == null) {
            view = mInflater.inflate(res, parent, false);
        } else {
            view = convertView;
        }

        ImageView image;
        image = (ImageView) view.findViewById(R.id.grid_item_picture_imageView);
        String pictureurl = getItem(position);
        Context context = getContext();
        Picasso.with(getContext()).load("http://i.imgur.com/DvpvklR.png").into(image);
        return image;
    }
}
