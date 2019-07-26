package com.teknoarktik.parcelabletrial;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class House implements Parcelable{
    private int price;
    private String location;
    private boolean nearSchool;
    private ArrayList<String> previousOwner;

    public House(int price, String location, boolean nearSchool, ArrayList<String> previousOwner) {
        this.price = price;
        this.location = location;
        this.nearSchool = nearSchool;
        this.previousOwner = previousOwner;
    }

    protected House(Parcel in) {
        // WARNING: It is extremely important to highlight that you must read the values in the same order that they were written in writeToParcel
        price = in.readInt();
        location = in.readString();
        nearSchool = in.readInt() == 1;
        previousOwner = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(price);
        dest.writeString(location);
        dest.writeInt( nearSchool ? 1 : 0 );
        dest.writeStringList( previousOwner );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isNearSchool() {
        return nearSchool;
    }

    public void setNearSchool(boolean nearSchool) {
        this.nearSchool = nearSchool;
    }

    public ArrayList<String> getPreviousOwner() {
        return previousOwner;
    }

    public void setPreviousOwner(ArrayList<String> previousOwner) {
        this.previousOwner = previousOwner;
    }
}
