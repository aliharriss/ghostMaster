package com.google.tflite.objectdetection.Fragments;

import android.os.Parcel;
import android.os.Parcelable;

public class TrainItem implements Parcelable {
    private int mImageResource1;
    private int mImageResource2;
    private String mText1;

    //Constructor I made
    public TrainItem(int imageResource1, int imageResource2, String text1) {
        mImageResource1 = imageResource1;
        mImageResource2 = imageResource2;
        mText1 = text1;
    }

    //Pre made constructor
    protected TrainItem(Parcel in) {
        mImageResource1 = in.readInt();
        mImageResource2 = in.readInt();
        mText1 = in.readString();
    }

    // uses pre made constructor to make new TrainItems
    public static final Creator<TrainItem> CREATOR = new Creator<TrainItem>() {
        @Override
        // Creates an example item from the parcel
        public TrainItem createFromParcel(Parcel in) {
            return new TrainItem(in);
        }

        @Override
        public TrainItem[] newArray(int size) {
            return new TrainItem[size];
        }
    };

    public int getmImageResource1() {
        return mImageResource1;
    }

    public int getmImageResource2() {
        return mImageResource2;
    }

    public String getText1() {
        return mText1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    // Adds the images and texts to the parcel
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource1);
        dest.writeInt(mImageResource2);
        dest.writeString(mText1);
    }
}
