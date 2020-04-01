package com.google.tflite.objectdetection.Fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.TrainViewHolder> {
    private ArrayList<TrainItem> mTrainList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onStartClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class TrainViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView1;
        public ImageView mImageView2;
        public TextView mTextView1;

        public TrainViewHolder (@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView1 = itemView.findViewById(R.id.imageViewEdit);
            mImageView2 = itemView.findViewById(R.id.imageViewStart);
            mTextView1 = itemView.findViewById(R.id.textView1);


            mImageView2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onStartClick(position);
                        }
                    }
                }
            });
        }
    }

    public TrainAdapter(ArrayList<TrainItem> trainList) {
        mTrainList = trainList;
    }

    @NonNull
    @Override
    public TrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_item, parent, false);
        TrainViewHolder evh = new TrainViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull TrainViewHolder holder, int position) {
        TrainItem currentItem = mTrainList.get(position);

        holder.mImageView1.setImageResource(currentItem.getmImageResource1());
        holder.mImageView2.setImageResource(currentItem.getmImageResource2());
        holder.mTextView1.setText(currentItem.getText1());
    }

    @Override
    public int getItemCount() {

        return mTrainList.size();
    }
}
