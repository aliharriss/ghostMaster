package com.google.tflite.objectdetection.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.tflite.objectdetection.DetectorActivity;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;

public class TrainFragment extends Fragment {
    // Start the detector activity
    Button button;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<String> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Start the detector activity
        View v = inflater.inflate(R.layout.fragment_train, container, false);

        // Start the detector activity
        button = v.findViewById(R.id.buttonTrain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetector();
            }
        });
        return v;
    }

    public void openDetector() {
        Intent intent = new Intent(getActivity(), DetectorActivity.class);
        startActivity(intent);
    }
}
