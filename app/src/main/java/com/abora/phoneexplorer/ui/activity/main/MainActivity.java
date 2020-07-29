package com.abora.phoneexplorer.ui.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.network.APIInterface;
import com.abora.phoneexplorer.network.ApiClient;
import com.abora.phoneexplorer.util.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navView;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        init();

    }

    private void init() {

        mainViewModel.getPhones();

        mainViewModel.phoneResponseMutableLiveData.observe(this, new Observer<List<PhoneResponse>>() {
            @Override
            public void onChanged(List<PhoneResponse> phoneResponses) {
                Toast.makeText(MainActivity.this, ""+ phoneResponses.get(0).getDeviceName(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navHome:

                Toast.makeText(MainActivity.this, "name home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navSearch:

                Toast.makeText(MainActivity.this, "navSearch", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navFavorite:

                Toast.makeText(MainActivity.this, "navFavorite", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}