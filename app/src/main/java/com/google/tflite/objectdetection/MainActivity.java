package com.google.tflite.objectdetection;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.tflite.objectdetection.Fragments.CommunityFragment;
import com.google.tflite.objectdetection.Fragments.SettingsFragment;
import com.google.tflite.objectdetection.Fragments.StatsFragment;
import com.google.tflite.objectdetection.Fragments.TrainFragment1;

import org.tensorflow.lite.examples.detection.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.setTitle("Train");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new TrainFragment1()).commit();
            navigationView.setCheckedItem(R.id.nav_train1);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_train1:
                this.setTitle("Train");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TrainFragment1()).commit();
                break;
            case R.id.nav_community:
                this.setTitle("Community");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CommunityFragment()).commit();
                break;
            case R.id.nav_stats:
                this.setTitle("Stats");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StatsFragment()).commit();
                break;
            case R.id.nav_settings:
                this.setTitle("Settings");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_review:
                Toast.makeText(this, "Review", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}