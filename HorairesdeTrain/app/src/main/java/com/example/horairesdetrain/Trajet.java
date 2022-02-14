package com.example.horairesdetrain;

import android.os.Parcel;
import android.os.Parcelable;

public class Trajet implements Parcelable {

    private String cityFrom, cityTo, time;

    public Trajet(String cityFrom, String cityTo, String time){
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.time = time;
    }

    protected Trajet(Parcel in) {
        cityFrom = in.readString();
        cityTo = in.readString();
        time = in.readString();
    }

    public static final Creator<Trajet> CREATOR = new Creator<Trajet>() {
        @Override
        public Trajet createFromParcel(Parcel in) {
            return new Trajet(in);
        }

        @Override
        public Trajet[] newArray(int size) {
            return new Trajet[size];
        }
    };

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cityFrom);
        parcel.writeString(cityTo);
        parcel.writeString(time);
    }
}
