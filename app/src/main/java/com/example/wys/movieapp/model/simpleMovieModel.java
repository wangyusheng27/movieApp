package com.example.wys.movieapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by wys on 2016/11/28.
 */
public class SimpleMovieModel implements Parcelable {
    private String juzhaoUrl;
    private String name;
    private String id;
    private String url;
    private String rating;
    private String pubdates;
    private String subtype;
    private String intro;
    private String allInfo;
    private int ratings_count;
    private int comments_count;
    private int actorsSize;
    private String[] actors;

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }


    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAllInfo() {
        return allInfo;
    }

    public void setAllInfo(String allInfo) {
        this.allInfo = allInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPubdates() {
        return pubdates;
    }

    public void setPubdates(String pubdates) {
        this.pubdates = pubdates;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }


    private SimpleMovieModel(Parcel parcel) {
        this.juzhaoUrl = parcel.readString();
        this.name = parcel.readString();
        this.id = parcel.readString();
        this.url = parcel.readString();
        this.rating = parcel.readString();
        this.pubdates = parcel.readString();
        this.subtype = parcel.readString();
        this.intro = parcel.readString();
        this.allInfo = parcel.readString();
        this.ratings_count = parcel.readInt();
        this.comments_count = parcel.readInt();
        this.actorsSize = parcel.readInt();
        this.actors = new String[actorsSize];
        parcel.readStringArray(this.actors);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(juzhaoUrl);
        dest.writeString(name);
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(rating);
        dest.writeString(pubdates);
        dest.writeString(subtype);
        dest.writeString(intro);
        dest.writeString(allInfo);
        dest.writeInt(ratings_count);
        dest.writeInt(comments_count);
        dest.writeInt(actors.length);
        dest.writeStringArray(actors);
    }

    public SimpleMovieModel(String juzhaoUrl, String name) {
        this.juzhaoUrl = juzhaoUrl;
        this.name = name;
    }

    ;

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


    public static final Parcelable.Creator<SimpleMovieModel> CREATOR = new Parcelable.Creator<SimpleMovieModel>() {
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
