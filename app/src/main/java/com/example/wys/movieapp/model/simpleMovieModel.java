package com.example.wys.movieapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wys on 2016/11/28.
 */
public class SimpleMovieModel implements Parcelable{
    private String juzhaoUrl;
    private String name;

    private SimpleMovieModel(Parcel parcel) {
        this.juzhaoUrl = parcel.readString();
        this.name = parcel.readString();
    }

    public SimpleMovieModel(String juzhaoUrl, String name){
        this.juzhaoUrl = juzhaoUrl;
        this.name = name;
    };
    public String getJuzhaoUrl() {
        return juzhaoUrl;
    }

    public void setJuzhaoUrl(String juzhaoUrl) {
        this.juzhaoUrl = juzhaoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(juzhaoUrl);
        dest.writeString(name);
    }

    public final Parcelable.Creator<SimpleMovieModel> CREATOR = new Parcelable.Creator<SimpleMovieModel>() {
        @Override
        public SimpleMovieModel createFromParcel(Parcel parcel) {
            return new SimpleMovieModel(parcel);
        }

        @Override
        public SimpleMovieModel[] newArray(int i) {
            return new SimpleMovieModel[i];
        }

    };
}
