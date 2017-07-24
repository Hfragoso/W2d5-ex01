package com.example.heber.w2d5_ex01;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by heber on 7/24/2017.
 */

public class ImageDetail implements Parcelable {

    private Bitmap photo;
    private String Name;
    private String Lastname;

    public ImageDetail() {
    }

    public ImageDetail(Bitmap photo, String name, String lastname) {
        this.photo = photo;
        Name = name;
        Lastname = lastname;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    @Override
    public String toString() {
        return "ImageDetail{" +
                "photo=" + photo +
                ", Name='" + Name + '\'' +
                ", Lastname='" + Lastname + '\'' +
                '}';
    }

    protected ImageDetail(Parcel in) {
        photo = (Bitmap) in.readValue(Bitmap.class.getClassLoader());
        Name = in.readString();
        Lastname = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photo);
        dest.writeString(Name);
        dest.writeString(Lastname);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ImageDetail> CREATOR = new Parcelable.Creator<ImageDetail>() {
        @Override
        public ImageDetail createFromParcel(Parcel in) {
            return new ImageDetail(in);
        }

        @Override
        public ImageDetail[] newArray(int size) {
            return new ImageDetail[size];
        }
    };
}