package com.google.tflite.objectdetection;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.tflite.objectdetection.Fragments.TrainItem;

import org.tensorflow.lite.examples.detection.R;

public class TrainEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_edit);

        // Get the mTrainList and position from TrainFragment
        Intent intent = getIntent();
        TrainItem mTrainItem = intent.getParcelableExtra("train item");
        //int trainNumber = intent.getIntExtra(TrainFragment1.EXTRA_NUMBER, 0);
        String trainName = mTrainItem.getText1();

        // Set some text views based on the TrainItem
        TextView trainItemName =  findViewById(R.id.trainItemName);
        TextView trainItemPosition = findViewById(R.id.trainItemPosition);
        trainItemName.setText(trainName);
        //trainItemPosition.setText(trainNumber);

        ///handle all the changes to the trainItem from user interactions


        ///update the trainItems array and save the data to shared prefs, once the train button is pressed
    }

    // Check if the user wants to save changes they've made
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Save Changes")
                .setMessage("Do you want to save your changes?")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TrainEdit.super.onBackPressed();
                    }
                })
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        ///save the data to shared prefs
                        showSavedToast();
                        //saveData();
                        TrainEdit.super.onBackPressed();
                    }
                }).create().show();
    }

    public void showSavedToast() {
        Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show();
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        //String json = gson.toJson(mTrainList);
    }
}
