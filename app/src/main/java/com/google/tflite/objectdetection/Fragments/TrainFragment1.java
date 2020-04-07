package com.google.tflite.objectdetection.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.tflite.objectdetection.TrainEdit;

import org.tensorflow.lite.examples.detection.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class TrainFragment1 extends Fragment {
    @Nullable

    private RecyclerView mRecyclerView;
    private TrainAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<TrainItem> mTrainList;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_train1, container, false);

        SharedPreferences prefs = getContext().getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        boolean firstStart = prefs.getBoolean("firstStart", true);

        // if it's the first launch, save default data, else load data
        if (firstStart) {
            Toast.makeText(getContext(), "save data",Toast.LENGTH_SHORT).show();
            createTrainList();
            saveData();
            editor.putBoolean("firstStart", false).apply();
        } else {
            Toast.makeText(getContext(), "load data",Toast.LENGTH_SHORT).show();
            loadData();
        }

        // build the example list
        buildRecyclerView(v);
        return v;
    }

    public void createTrainList() {
        // Only create default train list on the first app launch
        mTrainList = new ArrayList<>();
        mTrainList.add(new TrainItem(R.drawable.ic_menu_manage, R.drawable.ic_play, "Front Court"));
        mTrainList.add(new TrainItem(R.drawable.ic_menu_manage, R.drawable.ic_play, "Balanced"));
        mTrainList.add(new TrainItem(R.drawable.ic_menu_manage, R.drawable.ic_play, "Back Court"));
    }

    public void buildRecyclerView(View v) {
        mRecyclerView = v.findViewById(R.id.recyclerView);
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
               Toast.makeText(getContext(), "buttonStart pressed at pos: " + position,Toast.LENGTH_SHORT).show();
           }
           public void  onEditClick(int position){
               ///go to editTrainItem fragment
               Toast.makeText(getContext(), "buttonEdit pressed at pos: " + position,Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getContext(), TrainEdit.class);
               // Pass in the trainItems arraylist
               intent.putExtra("train item", mTrainList.get(position));
               startActivity(intent);
           }
        });
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mTrainList);
        editor.putString("train list", json);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("train list", null);
        Type type = new TypeToken<ArrayList<TrainItem>>() {}.getType();
        mTrainList = gson.fromJson(json, type);

        if (mTrainList == null) {
            mTrainList = new ArrayList<>();
        }
    }
}
