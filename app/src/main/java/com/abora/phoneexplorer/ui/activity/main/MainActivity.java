package com.abora.phoneexplorer.ui.activity.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.abora.phoneexplorer.ui.fragment.compare.CompareFragment;
import com.abora.phoneexplorer.ui.fragment.explore.ExploreFragment;
import com.abora.phoneexplorer.ui.fragment.settings.SettingsFragment;
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
        openFragment(new ExploreFragment(), "home");
        mainViewModel.getPhones();

        mainViewModel.phoneResponseMutableLiveData.observe(this, new Observer<List<PhoneResponse>>() {
            @Override
            public void onChanged(List<PhoneResponse> phoneResponses) {
                Toast.makeText(MainActivity.this, "" + phoneResponses.get(0).getDeviceName(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navHome:
                openFragment(new ExploreFragment(), "ExploreFragment");
                break;
            case R.id.navCompare:
                openFragment(new CompareFragment(), "CompareFragment");
                break;
            case R.id.navSettings:
                openFragment(new SettingsFragment(), "SettingsFragment");
                break;
        }
        return true;
    }

    private void openFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment, tag).commit();
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        Log.e("Fragments Quantity", String.valueOf(fragments.size()));
        fragmentManager.beginTransaction().show(fragment).commit();
    }

}