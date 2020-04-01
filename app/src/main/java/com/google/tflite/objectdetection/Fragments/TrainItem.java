package com.google.tflite.objectdetection.Fragments;

public class TrainItem {
    private int mImageResource1;
    private int mImageResource2;
    private String mText1;

    public TrainItem(int imageResource1, int imageResource2, String text1) {
        mImageResource1 = imageResource1;
        mImageResource2 = imageResource2;
        mText1 = text1;
    }

    public int getmImageResource1() {
        return mImageResource1;
    }

    public int getmImageResource2() {
        return mImageResource2;
    }

    public String getText1() {
        return mText1;
    }
}
