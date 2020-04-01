package com.google.tflite.objectdetection.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;
import java.util.Objects;

public class TrainFragment1 extends Fragment {
    @Nullable

    private RecyclerView mRecyclerView;
    private TrainAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<TrainItem> mTrainList;

    private ImageView imageStart;
    private ImageView imageEdit;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_train1, container, false);

        //Create Example List and build it
        createTrainList();
        buildRecyclerView(v);



        return v;
    }

    public void createTrainList() {
        mTrainList = new ArrayList<>();
        mTrainList.add(new TrainItem(R.drawable.ic_menu_manage, R.drawable.ic_play, "Front Court"));
        mTrainList.add(new TrainItem(R.drawable.ic_menu_manage, R.drawable.ic_play, "Balanced"));
        mTrainList.add(new TrainItem(R.drawable.ic_menu_manage, R.drawable.ic_play, "Back Court"));
    }

    public void buildRecyclerView(View v) {        mRecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new TrainAdapter(mTrainList);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(getContext(), R.drawable.divider)));

        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        mAdapter.setOnItemClickListener(new TrainAdapter.OnItemClickListener(){
           @Override
           public void onStartClick(int position) {
               ///pass in variables and start training activity
               Toast.makeText(getContext(), "Hello Javatpoint",Toast.LENGTH_SHORT).show();
           }

/*            @Override
            public void onEditClick(int position) {
                ///go to edit train activity to change some variables for the training activity
            }*/
        });
    }
}
